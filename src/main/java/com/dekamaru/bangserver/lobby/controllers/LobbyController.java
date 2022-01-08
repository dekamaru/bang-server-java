package com.dekamaru.bangserver.lobby.controllers;

import com.dekamaru.bangserver.lobby.responses.*;
import com.dekamaru.bangserver.transport.models.Command;
import com.dekamaru.bangserver.transport.models.Connection;
import com.dekamaru.bangserver.lobby.models.Lobby;
import com.dekamaru.bangserver.lobby.repositories.LobbyRepository;
import com.dekamaru.bangserver.lobby.requests.JoinLobbyRequest;
import com.dekamaru.bangserver.lobby.requests.SetNicknameRequest;
import com.dekamaru.bangserver.transport.controllers.Controller;
import com.dekamaru.bangserver.transport.responses.ErrorRequestResponse;
import com.dekamaru.bangserver.transport.responses.RequestResponse;
import com.dekamaru.bangserver.transport.responses.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LobbyController implements Controller {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final LobbyRepository repository;

    public LobbyController(LobbyRepository repository) {
        this.repository = repository;
    }

    @Override
    public String getName() {
        return "lobby";
    }

    @Override
    public Response handle(Connection caller, Command command) {
        switch(command.method) {
            case "setNickname":
                return setNickname(caller, command);
            case "getLobbyList":
                return getLobbyList(caller, command);
            case "createLobby":
                return createLobby(caller, command);
            case "joinLobby":
                return joinLobby(caller, command);
            case "markReady":
                return markReady(caller, command);
            case "exitLobby":
                return exitLobby(caller, command);
            case "startGame":
                return startGame(caller, command);
            default:
                return new ErrorRequestResponse(command.id, "Method not found");
        }
    }

    private Response startGame(Connection caller, Command command) {
        // TODO: implement it
        return new RequestResponse(command.id, true);
    }

    private Response exitLobby(Connection caller, Command command) {
        if (!caller.isInLobby()) {
            return new ErrorRequestResponse(command.id, "You need to join lobby first");
        }

        // TODO: if host leaving lobby need to re-assign host in the lobby.
        // TODO: if last player left - remove lobby
        var lobby = caller.getCurrentLobby();
        lobby.leave(caller);

        try {
            lobby.broadcastMessageExcept(new PlayerLeftLobbyEventResponse(caller.getId()), caller);
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorRequestResponse(command.id, "Something went wrong. Stacktrace in console");
        }

        return new RequestResponse(command.id, true);
    }

    private Response markReady(Connection caller, Command command) {
        if (!caller.isInLobby()) {
            return new ErrorRequestResponse(command.id, "You need to join lobby first");
        }

        var lobby = caller.getCurrentLobby();
        var ready = lobby.markAsReady(caller);
        try {
            lobby.broadcastMessageExcept(new PlayerReadyStateEventResponse(caller.getId(), ready), caller);

            return new PlayerReadyStateResponse(command.id, ready);
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorRequestResponse(command.id, "Something went wrong. Stacktrace in console");
        }
    }

    private Response joinLobby(Connection caller, Command command) {
        if (null == caller.getNickname()) {
            return new ErrorRequestResponse(command.id, "Nickname not set");
        }

        if (caller.isInLobby()) {
            return new ErrorRequestResponse(command.id, "You need to leave current lobby in order to join different");
        }

        try {
            var request = objectMapper.readValue(command.parameters.toString(), JoinLobbyRequest.class);
            var lobby = repository.getLobbyById(request.getLobbyId());
            if (null == lobby) {
                return new ErrorRequestResponse(command.id, "Lobby not found");
            }

            lobby.join(caller);
            lobby.broadcastMessageExcept(
                    new PlayerJoinedLobbyEventResponse(caller.getId(), caller.getNickname()),
                    caller
            );

            return new LobbyResponse(command.id, lobby);
        } catch (JsonProcessingException exception) {
            return new ErrorRequestResponse(command.id, "Invalid request");
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorRequestResponse(command.id, "Something went wrong. Stacktrace in console");
        }
    }

    private Response getLobbyList(Connection caller, Command command) {
        if (null == caller.getNickname()) {
            return new ErrorRequestResponse(command.id, "Nickname not set");
        }

        return new LobbyListResponse(command.id, repository.getLobbies());
    }

    private Response createLobby(Connection caller, Command command) {
        if (null == caller.getNickname()) {
            return new ErrorRequestResponse(command.id, "Nickname not set");
        }

        if (caller.isInLobby()) {
            return new ErrorRequestResponse(command.id, "You need to leave current lobby in order to create new one");
        }

        var lobby = new Lobby(caller);
        repository.createLobby(lobby);

        return new LobbyResponse(command.id, lobby);
    }

    private Response setNickname(Connection caller, Command command) {
        if (null != caller.getNickname()) {
            return new ErrorRequestResponse(command.id, "Nickname already set");
        }

        try {
            var request = objectMapper.readValue(command.parameters.toString(), SetNicknameRequest.class);
            if (request.getNickname().trim().isEmpty()) {
                return new ErrorRequestResponse(command.id, "Invalid nickname");
            }

            caller.setNickname(request.getNickname());
        } catch (JsonProcessingException exception) {
            return new ErrorRequestResponse(command.id, "Invalid request");
        }

        return new RequestResponse(command.id, true);
    }
}
