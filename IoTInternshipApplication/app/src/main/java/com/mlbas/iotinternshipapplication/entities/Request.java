package com.mlbas.iotinternshipapplication.entities;

public class Request {
    private String path;
    private String requestMethod;

    public void withPath(String path){
        this.path = path;
    }

    public void withMethod(String method){
        this.requestMethod = method;
    }

    public String getPath() {
        return path;
    }

    public String getRequestMethod() {
        return requestMethod;
    }
}

