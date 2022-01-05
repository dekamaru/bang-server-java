package com.dekamaru.bangserver.models;

import com.dekamaru.bangserver.responses.RequestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

public class Connection {
    private final WebSocketSession session;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private String nickname;

    public Connection(WebSocketSession session) {
        this.session = session;
    }

    public WebSocketSession getSession() {
        return session;
    }

    public String getNickname() {
        return nickname;
    }

    public void sendMessage(Object message) throws IOException {
        session.sendMessage(new TextMessage(this.objectMapper.writeValueAsString(message)));
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
