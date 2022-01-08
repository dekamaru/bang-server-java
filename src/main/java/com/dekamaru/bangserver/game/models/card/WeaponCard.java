package com.dekamaru.bangserver.game.models.card;

public class WeaponCard extends Card {
    private final int range;
    private final boolean unlimitedBangs;

    public WeaponCard(Suit suit, int rank, int range, boolean unlimitedBangs) {
        super(suit, rank);
        this.range = range;
        this.unlimitedBangs = unlimitedBangs;
    }

    public int getRange() {
        return range;
    }

    public boolean isUnlimitedBangs() {
        return unlimitedBangs;
    }
}