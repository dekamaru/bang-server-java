package com.dekamaru.bangserver.responses.lobby;

import com.dekamaru.bangserver.models.Lobby;
import com.dekamaru.bangserver.responses.RequestResponse;

import java.util.Collection;

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
