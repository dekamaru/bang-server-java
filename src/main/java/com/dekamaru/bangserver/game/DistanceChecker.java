package com.dekamaru.bangserver.game;

import com.dekamaru.bangserver.game.models.Player;
import com.dekamaru.bangserver.game.models.card.BuffCard;

import java.util.List;

public class DistanceChecker {
    public boolean canReachTarget(Player from, Player to, List<Player> players) {
        var distance = this.getFinalDistance(from, to, players);
        return from.getWeaponRange() >= distance;
    }

    private int getFinalDistance(Player from, Player to, List<Player> players) {
        var baseDistance = getBaseDistance(from, to, players);
        var finalDistance = baseDistance + this.getDistanceModifier(from, to);

        return finalDistance <= 0 ? 1 : finalDistance;
    }

    private int getDistanceModifier(Player from, Player to) {
        var distanceModifier = 0;
        if (from.hasBuff(BuffCard.Type.SCOPE)) {
            distanceModifier--;
        }

        if (to.hasBuff(BuffCard.Type.MUSTANG)) {
            distanceModifier++;
        }

        return distanceModifier;
    }

    private int getBaseDistance(Player from, Player to, List<Player> players) {
        var playerIndex = players.indexOf(from);
        var left = playerIndex;
        var right = playerIndex;
        var distance = 0;

        do {
            left--;
            right++;
            distance++;

            if (left < 0) {
                left = players.size() - 1;
            }

            if (right > players.size() - 1) {
                right = 0;
            }

        } while (!players.get(left).equals(to) && !players.get(right).equals(to));

        return distance;
    }
}
