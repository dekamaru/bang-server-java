package com.dekamaru.bangserver.game.models;

import com.dekamaru.bangserver.game.CardDealer;
import com.dekamaru.bangserver.game.DistanceChecker;
import com.dekamaru.bangserver.game.data.CardData;
import com.dekamaru.bangserver.game.data.HeroData;
import com.dekamaru.bangserver.transport.models.Connection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Game {
    private final String id;
    private final ConcurrentHashMap<String, Player> players = new ConcurrentHashMap<>();
    private final CardDealer cardDealer = new CardDealer(CardData.list);
    private final DistanceChecker distanceChecker = new DistanceChecker();
    private Player currentTurn;

    public Game(String id, ConcurrentHashMap<String, Connection> connections) {
        this.id = id;
        createPlayers(connections);
    }

    public void start() {
        // TODO: share players data
    }

    private void createPlayers(ConcurrentHashMap<String, Connection> connections) {
        var roles = new ArrayList<>(Player.Role.getRolesForPlayers(connections.size()));
        var heroes = new ArrayList<>(HeroData.list);

        Collections.shuffle(roles);
        Collections.shuffle(heroes);

        for (var connection : connections.values()) {
            var hero = heroes.get(0);
            var role = roles.get(0);

            var player = new Player(connection, hero, role);
            this.players.put(connection.getId(), player);
            if (role == Player.Role.SHERIFF) {
                currentTurn = player;
            }

            heroes.remove(0);
            roles.remove(0);
        }
    }
}
