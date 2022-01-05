package com.dekamaru.bangserver.responses;

public abstract class EventResponse extends Response {
    public enum EventType {
        PLAYER_JOINED_LOBBY,
        PLAYER_LEFT_LOBBY,
        PLAYER_READY_STATE,
    }

    private EventType event;

    public EventResponse(EventType event) {
        super(ResponseType.EVENT);
        this.event = event;
    }

    public EventType getEvent() {
        return event;
    }
}
