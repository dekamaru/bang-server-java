package com.dekamaru.bangserver.game.responses;

import com.dekamaru.bangserver.game.models.Player;
import com.dekamaru.bangserver.transport.responses.EventResponse;

public class RoleRevealEventResponse extends EventResponse {
    private String playerId;
    private Player.Role role;

    public RoleRevealEventResponse(String playerId, Player.Role role) {
        super(EventType.ROLE_REVEAL);
        this.playerId = playerId;
        this.role = role;
    }

    public String getPlayerId() {
        return playerId;
    }

    public Player.Role getRole() {
        return role;
    }
}
