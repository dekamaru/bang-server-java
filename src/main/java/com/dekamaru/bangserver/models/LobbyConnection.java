package com.dekamaru.bangserver.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"connection"})
public class LobbyConnection {
    private Connection connection;
    private boolean ready;
    private boolean host;

    public LobbyConnection(Connection connection, boolean host) {
        this.connection = connection;
        this.host = host;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public Connection getConnection() {
        return connection;
    }

    public String getNickname() {
        return connection.getNickname();
    }

    @JsonProperty("id")
    public String getConnectionId() {
        return connection.getConnectionId();
    }

    public boolean isHost() {
        return host;
    }
}
