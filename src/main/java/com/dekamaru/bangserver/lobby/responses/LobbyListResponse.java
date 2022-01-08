package com.dekamaru.bangserver.lobby.responses;

import com.dekamaru.bangserver.lobby.models.Lobby;
import com.dekamaru.bangserver.transport.responses.RequestResponse;

import java.util.Collection;

public class LobbyListResponse extends RequestResponse {
    private Collection<Lobby> lobbies;

    public LobbyListResponse(String id, Collection<Lobby> lobbies) {
        super(id, true);
        this.lobbies = lobbies;
    }

    public Collection<Lobby> getLobbies() {
        return lobbies;
    }
}
