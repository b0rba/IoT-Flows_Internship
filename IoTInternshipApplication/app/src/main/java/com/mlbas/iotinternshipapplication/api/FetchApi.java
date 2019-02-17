package com.mlbas.iotinternshipapplication.api;

import android.os.AsyncTask;
import android.util.Log;

import com.mlbas.iotinternshipapplication.entities.Request;
import com.mlbas.iotinternshipapplication.interfaces.OnFinishRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

import static android.content.ContentValues.TAG;

public class FetchApi {

    private OnFinishRequest listener;

    public FetchApi(OnFinishRequest listener){
        this.listener = listener;
    }

    final private OnFinishRequest handler = new OnFinishRequest() {
        @Override
        public void OnFinishRequest(String data) {
            listener.OnFinishRequest(data);
        }

        @Override
        public void OnError(String msg) {
            listener.OnError(msg);
        }
    };

    public void fetchData(String path, String method){
        Request mRequest = new Request();
        mRequest.withPath(path);
        mRequest.withMethod(method);
        new FetchAsyncTask().execute(mRequest);
    }

    private class FetchAsyncTask extends AsyncTask<Request, Void, String> {

        @Override
        protected String doInBackground(Request... requests) {
            String finalResponse = "";
            try {
                URL url = new URL(requests[0].getPath());
                InputStream is = url.openStream();
                if(is != null){
                    finalResponse = readInputStream(is);
                }
            }catch (final Exception exception){
                exception.printStackTrace();
            }

            return finalResponse;
        }

        private String readInputStream(InputStream fetched) throws IOException {

            BufferedReader rd = new BufferedReader(new InputStreamReader(fetched, Charset.forName("UTF-8")));
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            String jsonText = sb.toString();
            return jsonText;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            listener.OnFinishRequest(s);
        }

    }
}
