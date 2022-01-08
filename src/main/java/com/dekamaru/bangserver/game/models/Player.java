package com.dekamaru.bangserver.game.models;

import com.dekamaru.bangserver.game.models.card.BuffCard;
import com.dekamaru.bangserver.game.models.card.WeaponCard;
import com.dekamaru.bangserver.transport.models.Connection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Player {
    public enum Role {
        DEPUTY,
        SHERIFF,
        OUTLAW,
        RENEGADE;

        public static List<Role> getRolesForPlayers (int playerCount) {
            var list = new ArrayList<Role>();
            list.add(SHERIFF);
            list.add(RENEGADE);
            list.add(OUTLAW);
            list.add(OUTLAW);

            if (playerCount == 5) {
                list.add(DEPUTY);
            }

            if (playerCount == 6) {
                list.add(OUTLAW);
            }

            if (playerCount == 7) {
                list.add(DEPUTY);
            }

            return list;
        }
    }

    private final Connection connection;
    private int health;
    private final Hero hero;
    private WeaponCard weapon;
    private List<BuffCard> buffs = new ArrayList<>();
    private final Role role;

    public Player(Connection connection, Hero hero, Role role) {
        this.connection = connection;
        this.health = hero.getHealth() + (role == Role.SHERIFF ? 1 : 0);
        this.hero = hero;
        this.role = role;
    }

    public String getId() {
        return connection.getId();
    }

    public void sendMessage(Object message) throws IOException {
        connection.sendMessage(message);
    }

    public int getWeaponRange() {
        if (null == weapon) {
            return 1;
        }

        return weapon.getRange();
    }

    public boolean hasBuff(BuffCard.Type buff) {
        for (var card : buffs) {
            if (card.getBuff() == buff) {
                return true;
            }
        }

        return false;
    }
}
