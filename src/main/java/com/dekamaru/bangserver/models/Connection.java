package com.dekamaru.bangserver.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Objects;

public class Connection {
    private final WebSocketSession session;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private String nickname;
    private Lobby currentLobby;

    public Connection(WebSocketSession session) {
        this.session = session;
    }

    public WebSocketSession getSession() {
        return session;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getConnectionId() {
        return session.getId();
    }

    public boolean isInLobby() {
        return null != currentLobby;
    }

    public Lobby getCurrentLobby() {
        return currentLobby;
    }

    public void setCurrentLobby(Lobby currentLobby) {
        this.currentLobby = currentLobby;
    }

    public void sendMessage(Object message) throws IOException {
        session.sendMessage(new TextMessage(this.objectMapper.writeValueAsString(message)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connection that = (Connection) o;

        return that.getConnectionId().equals(this.getConnectionId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getConnectionId());
    }
}
