package com.dekamaru.bangserver.controllers;

import com.dekamaru.bangserver.models.Command;
import com.dekamaru.bangserver.models.Connection;
import com.dekamaru.bangserver.requests.SetNicknameRequest;
import com.dekamaru.bangserver.responses.ErrorRequestResponse;
import com.dekamaru.bangserver.responses.RequestResponse;
import com.dekamaru.bangserver.responses.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class LobbyController implements Controller {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String getName() {
        return "lobby";
    }

    @Override
    public Response handle(Connection caller, Command command) {
        switch(command.method) {
            case "setNickname":
                return setNickname(caller, command);
            default:
                return new ErrorRequestResponse(command.id, "Method not found");
        }
    }

    private Response setNickname(Connection caller, Command command) {
        if (null != caller.getNickname()) {
            return new ErrorRequestResponse(command.id, "Nickname already set");
        }

        try {
            var request = objectMapper.readValue(
                    command.parameters.toString(),
                    SetNicknameRequest.class
            );

            System.out.println(request);

        } catch (JsonProcessingException exception) {
            System.out.println(exception.getMessage());
            return new ErrorRequestResponse(command.id, "Invalid request");
        }

        return new RequestResponse(command.id, true);
    }
}
