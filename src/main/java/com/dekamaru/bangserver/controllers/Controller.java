package com.dekamaru.bangserver.controllers;

import com.dekamaru.bangserver.models.Command;
import com.dekamaru.bangserver.models.Connection;
import com.dekamaru.bangserver.responses.Response;

public interface Controller {
    public String getName();
    public Response handle(Connection caller, Command command);
}
