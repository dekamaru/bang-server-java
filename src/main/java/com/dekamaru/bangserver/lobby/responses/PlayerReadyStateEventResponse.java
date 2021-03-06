package com.dekamaru.bangserver.lobby.responses;

import com.dekamaru.bangserver.transport.responses.EventResponse;

public class PlayerReadyStateEventResponse extends EventResponse {
    private String id;
    private boolean ready;

    public PlayerReadyStateEventResponse(String id, boolean ready) {
        super(EventType.PLAYER_READY_STATE);
        this.id = id;
        this.ready = ready;
    }

    public String getId() {
        return id;
    }

    public boolean isReady() {
        return ready;
    }
}
