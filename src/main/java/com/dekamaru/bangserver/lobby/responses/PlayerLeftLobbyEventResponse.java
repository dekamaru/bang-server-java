package com.dekamaru.bangserver.lobby.responses;

import com.dekamaru.bangserver.transport.responses.EventResponse;

public class PlayerLeftLobbyEventResponse extends EventResponse {
    private String id;

    public PlayerLeftLobbyEventResponse(String id) {
        super(EventType.PLAYER_LEFT_LOBBY);
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
