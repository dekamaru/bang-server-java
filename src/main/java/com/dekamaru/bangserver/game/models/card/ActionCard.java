package com.dekamaru.bangserver.game.models.card;

public class ActionCard extends Card {
    public enum Type {
        BANG,
        MISSED,
        DILIGENZA,
        WELLS_FARGO,
        GATLING,
        SALOON,
        INDIANS,
        DUEL,
        PANIC,
        CAT_BALOU,
        BEER,
        SHOP
    }

    private final Type action;

    public ActionCard(Suit suit, int rank, Type action) {
        super(suit, rank);
        this.action = action;
    }

    public Type getAction() {
        return action;
    }
}