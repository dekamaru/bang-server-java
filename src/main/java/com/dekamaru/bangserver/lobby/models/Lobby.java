package com.dekamaru.bangserver.lobby.models;

import com.dekamaru.bangserver.transport.models.Connection;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Lobby {
    private final String id;
    private final String name;
    private final Connection host;
    private final List<Connection> connections = Collections.synchronizedList(new ArrayList<>());
    private final ConcurrentHashMap<Connection, Boolean> readyTable = new ConcurrentHashMap<>();

    public Lobby(Connection host) {
        this.id = UUID.randomUUID().toString();
        this.name = String.format("%s's game", host.getNickname());
        this.host = host;
        this.connections.add(host);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Connection getHost() {
        return host;
    }

    @JsonProperty("players")
    public List<Connection> getConnections() {
        return connections;
    }

    public void join(Connection player) {
        this.connections.add(player);
        player.setCurrentLobby(this);
    }

    public void leave(Connection player) {
        this.connections.remove(player);
        player.setCurrentLobby(null);
    }

    public boolean markAsReady(Connection player) {
        var ready = !readyTable.getOrDefault(player, false);
        readyTable.put(player, ready);

        return ready;
    }

    public void broadcastMessageExcept(Object message, Connection player) throws IOException {
        for (var connection : connections) {
            if (connection.equals(player)) {
                continue;
            }

            connection.sendMessage(message);
        }
    }
}
