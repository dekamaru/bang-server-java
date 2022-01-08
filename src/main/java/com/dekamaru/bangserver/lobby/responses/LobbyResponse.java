package com.dekamaru.bangserver.lobby.responses;

import com.dekamaru.bangserver.lobby.models.Lobby;
import com.dekamaru.bangserver.transport.responses.RequestResponse;

public class LobbyResponse extends RequestResponse {
    private Lobby lobby;

    public LobbyResponse(String id, Lobby lobby) {
        super(id, true);
        this.lobby = lobby;
    }

    public Lobby getLobby() {
        return lobby;
    }
}
