package com.dekamaru.bangserver.game;

import com.dekamaru.bangserver.game.models.card.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDealer {
    private final List<Card> cards;
    private final ArrayList<Card> used = new ArrayList<>();

    public CardDealer(List<Card> cards) {
        this.cards = cards;
        Collections.shuffle(this.cards);
    }

    public List<Card> takeMany(int count) {
        if (cards.size() < count) {
            combineUsedCards();
        }

        return this.cards.subList(0, count);
    }

    public Card takeOne() {
        if (cards.size() == 0) {
            combineUsedCards();
        }

        var card = cards.get(0);
        cards.remove(0);

        return card;
    }

    public void place(Card card) {
        used.add(card);
    }

    public int getCardsCount() {
        return cards.size();
    }

    public int getUsedCardsCount() {
        return used.size();
    }

    private void combineUsedCards() {
        Collections.shuffle(used);
        cards.addAll(used);
        used.clear();
    }
}
