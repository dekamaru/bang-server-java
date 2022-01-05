package com.dekamaru.bangserver.responses.lobby;

import com.dekamaru.bangserver.models.Lobby;
import com.dekamaru.bangserver.responses.RequestResponse;

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
