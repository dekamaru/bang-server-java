package com.dekamaru.bangserver.game.models.card;

public class BuffCard extends Card {
    public enum Type {
        JAIL,
        DYNAMITE,
        SCOPE,
        MUSTANG,
        BARREL
    }

    private final Type buff;

    public BuffCard(Suit suit, int rank, Type buff) {
        super(suit, rank);
        this.buff = buff;
    }

    public Type getBuff() {
        return buff;
    }
}