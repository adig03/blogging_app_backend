package com.example.Blogging.Application.payloads;

public class ApiResponse {

    private String message;
    private boolean success;

    // No-argument constructor
    public ApiResponse() {
    }

    // Getter for message
    public String getMessage() {
        return message;
    }

    // Setter for message
    public void setMessage(String message) {
        this.message = message;
    }

    // Getter for success
    public boolean isSuccess() {
        return success;
    }

    // Setter for success
    public void setSuccess(boolean success) {
        this.success = success;
    }


    // Parameterized constructor
    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
