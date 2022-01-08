package com.dekamaru.bangserver.transport.controllers;

import com.dekamaru.bangserver.transport.models.Command;
import com.dekamaru.bangserver.transport.models.Connection;
import com.dekamaru.bangserver.transport.responses.Response;

public interface Controller {
    String getName();
    Response handle(Connection caller, Command command);
}
