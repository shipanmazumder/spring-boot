package com.shipan.cruddemo.rest;

public class ErrorResponse {
    private int code;
    private String message;
    private boolean status;

    public ErrorResponse(int code, String message, boolean status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    public ErrorResponse() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
