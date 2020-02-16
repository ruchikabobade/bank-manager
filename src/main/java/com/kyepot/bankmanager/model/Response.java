package com.kyepot.bankmanager.model;

public class Response {

    private String status;
    private int code;
    private String message;

    public Response(String status, int code, String message){
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

}
