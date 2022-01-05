package com.dekamaru.bangserver;

import com.dekamaru.bangserver.controllers.Controller;
import com.dekamaru.bangserver.models.Command;
import com.dekamaru.bangserver.models.Connection;
import com.dekamaru.bangserver.responses.ErrorRequestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class WebSocketHandler extends TextWebSocketHandler {
    private ConcurrentHashMap<String, Connection> connections;
    private HashMap<String, Controller> controllers;

    public WebSocketHandler(List<Controller> controllers) {
        connections = new ConcurrentHashMap<>();
        this.controllers = new HashMap<>();
        for (var controller : controllers) {
            this.controllers.put(controller.getName(), controller);
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        connections.put(session.getId(), new Connection(session));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        connections.remove(session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        try {
            var command = new ObjectMapper().readValue(message.getPayload(), Command.class);
            var connection = connections.get(session.getId());

            if (!controllers.containsKey(command.controller)) {
                connection.sendMessage(new ErrorRequestResponse(command.id, "Controller not found"));
                return;
            }

            connection.sendMessage(controllers.get(command.controller).handle(connection, command));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
