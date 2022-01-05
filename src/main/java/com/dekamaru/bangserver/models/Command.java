package com.dekamaru.bangserver.models;

import com.fasterxml.jackson.databind.JsonNode;

public class Command {
    public String id;
    public String controller;
    public String method;
    public JsonNode parameters;
}
