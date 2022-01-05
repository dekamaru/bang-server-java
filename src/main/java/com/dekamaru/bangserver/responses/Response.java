package com.dekamaru.bangserver.responses;

public abstract class Response {
    public enum Type {
        RESPONSE,
        EVENT
    }

    private final Type type;

    public Response(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
