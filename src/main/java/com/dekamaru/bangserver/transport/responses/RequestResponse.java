package com.dekamaru.bangserver.transport.responses;

public class RequestResponse extends Response {
    private String id;
    private boolean success;

    public RequestResponse(String id, boolean success) {
        super(ResponseType.REQUEST_RESPONSE);
        this.id = id;
        this.success = success;
    }

    public String getId() {
        return id;
    }

    public boolean isSuccess() {
        return success;
    }
}
