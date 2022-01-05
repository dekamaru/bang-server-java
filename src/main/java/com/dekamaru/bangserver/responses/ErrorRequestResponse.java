package com.dekamaru.bangserver.responses;

public class ErrorRequestResponse extends RequestResponse {
    private String message;

    public ErrorRequestResponse(String id, String message) {
        super(id, false);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
