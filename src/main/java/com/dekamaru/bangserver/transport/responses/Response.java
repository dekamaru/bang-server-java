package com.dekamaru.bangserver.transport.responses;

public abstract class Response {
    public enum ResponseType {
        REQUEST_RESPONSE,
        EVENT
    }

    private final ResponseType type;

    public Response(ResponseType type) {
        this.type = type;
    }

    public ResponseType getType() {
        return type;
    }
}
