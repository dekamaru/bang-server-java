package com.dekamaru.bangserver.lobby.responses;

import com.dekamaru.bangserver.transport.responses.EventResponse;

public class PlayerJoinedLobbyEventResponse extends EventResponse {
    private String id;
    private String nickname;

    public PlayerJoinedLobbyEventResponse(String id, String nickname) {
        super(EventType.PLAYER_JOINED_LOBBY);
        this.id = id;
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }
}
