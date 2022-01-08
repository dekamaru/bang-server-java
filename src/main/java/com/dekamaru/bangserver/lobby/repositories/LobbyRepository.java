package com.dekamaru.bangserver.lobby.repositories;

import com.dekamaru.bangserver.lobby.models.Lobby;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class LobbyRepository {
    private ConcurrentHashMap<String, Lobby> lobbies;

    public LobbyRepository() {
        this.lobbies = new ConcurrentHashMap<>();
    }

    public Collection<Lobby> getLobbies() {
        return this.lobbies.values();
    }

    public void createLobby(Lobby lobby) {
        this.lobbies.put(lobby.getId(), lobby);
    }

    public Lobby getLobbyById(String id) {
        return this.lobbies.get(id);
    }
}
