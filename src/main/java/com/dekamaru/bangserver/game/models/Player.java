package com.dekamaru.bangserver.game.models;

import com.dekamaru.bangserver.game.models.card.BuffCard;
import com.dekamaru.bangserver.game.models.card.WeaponCard;
import com.dekamaru.bangserver.transport.models.Connection;

import java.util.List;

public class Player {
    public enum Role {
        DEPUTY,
        SHERIFF,
        OUTLAW,
        RENEGADE
    }

    private Connection connection;
    private int health;
    private Hero hero;
    private WeaponCard weapon;
    private List<BuffCard> buffs;
    private Role role;
}
