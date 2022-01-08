package com.dekamaru.bangserver.lobby.responses;

import com.dekamaru.bangserver.transport.responses.RequestResponse;

public class PlayerReadyStateResponse extends RequestResponse {
    private boolean ready;

    public PlayerReadyStateResponse(String id, boolean ready) {
        super(id, true);
        this.ready = ready;
    }

    public boolean isReady() {
        return ready;
    }
}
