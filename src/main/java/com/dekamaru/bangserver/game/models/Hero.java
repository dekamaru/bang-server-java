package com.dekamaru.bangserver.game.models;

public class Hero {
    public enum Type {
        KILLER,
        JANET,
        BLACK_JACK,
        SAM,
        PEDRO,
        KIT,
        PAUL,
        GRINGO,
        JESSY,
        ROSE,
        JORDONNAS,
        WILLY,
        SUZIE,
        SID,
        BART,
        DUKE
    }

    private final Type type;
    private final int health;

    public Hero(Type type, int health) {
        this.type = type;
        this.health = health;
    }

    public Type getType() {
        return type;
    }

    public int getHealth() {
        return health;
    }
}
