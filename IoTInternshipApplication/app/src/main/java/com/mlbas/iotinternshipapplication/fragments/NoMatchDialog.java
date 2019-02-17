package com.mlbas.iotinternshipapplication.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;

import com.mlbas.iotinternshipapplication.R;
import com.mlbas.iotinternshipapplication.interfaces.DialogListener;

public class NoMatchDialog extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle SavedInstanceState){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog_nomatch, null);

        builder.setView(view)
                .setPositiveButton(getResources().getString(R.string.dialog_dismiss), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });
        return builder.create();
    }

}
