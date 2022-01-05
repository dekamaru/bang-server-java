package com.dekamaru.bangserver.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;
import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Lobby {
    private String id;
    private String name;
    @JsonProperty("players") private ConcurrentHashMap<String, LobbyConnection> connections;

    public Lobby(Connection host) {
        this.id = UUID.randomUUID().toString();
        this.connections = new ConcurrentHashMap<>();
        this.name = String.format("%s's game", host.getNickname());

        this.connections.put(host.getConnectionId(), new LobbyConnection(host, true));
        host.setCurrentLobby(this);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<LobbyConnection> getConnections() {
        return connections.values();
    }

    public void join(Connection player) {
        this.connections.put(player.getConnectionId(), new LobbyConnection(player, false));
        player.setCurrentLobby(this);
    }

    public void leave(Connection player) {
        this.connections.remove(player.getConnectionId());
        player.setCurrentLobby(null);
    }

    public boolean markAsReady(Connection player) {
        var lobbyConnection = this.connections.get(player.getConnectionId());
        var newValue = !lobbyConnection.isReady();
        lobbyConnection.setReady(newValue);

        return newValue;
    }

    public void broadcastMessageExcept(Object message, Connection player) throws IOException {
        for (var lobbyConnection : getConnections()) {
            if (lobbyConnection.getConnection().equals(player)) {
                continue;
            }

            lobbyConnection.getConnection().sendMessage(message);
        }
    }
}
