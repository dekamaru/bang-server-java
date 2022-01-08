package com.dekamaru.bangserver.game.data;

import com.dekamaru.bangserver.game.models.card.ActionCard;
import com.dekamaru.bangserver.game.models.card.BuffCard;
import com.dekamaru.bangserver.game.models.card.Card;
import com.dekamaru.bangserver.game.models.card.WeaponCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardData {
    public static final List<Card> list = new ArrayList<>(Arrays.asList(
            new WeaponCard(Card.Suit.CLUBS, 10, 1, true),
            new WeaponCard(Card.Suit.SPADES, 10, 1, true),
            new WeaponCard(Card.Suit.CLUBS, Card.RANK_JACK, 2, false),
            new WeaponCard(Card.Suit.CLUBS, Card.RANK_QUEEN, 2, false),
            new WeaponCard(Card.Suit.SPADES, Card.RANK_KING, 2, false),
            new WeaponCard(Card.Suit.CLUBS, Card.RANK_KING, 3, false),
            new WeaponCard(Card.Suit.CLUBS, Card.RANK_ACE, 4, false),
            new WeaponCard(Card.Suit.SPADES, 8, 5, false),

            new BuffCard(Card.Suit.HEARTS, 8, BuffCard.Type.MUSTANG),
            new BuffCard(Card.Suit.HEARTS, 9, BuffCard.Type.MUSTANG),
            new BuffCard(Card.Suit.HEARTS, 2, BuffCard.Type.DYNAMITE),
            new BuffCard(Card.Suit.SPADES, Card.RANK_ACE, BuffCard.Type.SCOPE),
            new BuffCard(Card.Suit.SPADES, 10, BuffCard.Type.JAIL),
            new BuffCard(Card.Suit.SPADES, 11, BuffCard.Type.JAIL),
            new BuffCard(Card.Suit.HEARTS, 4, BuffCard.Type.JAIL),
            new BuffCard(Card.Suit.SPADES, Card.RANK_QUEEN, BuffCard.Type.BARREL),
            new BuffCard(Card.Suit.SPADES, Card.RANK_KING, BuffCard.Type.BARREL),

            new ActionCard(Card.Suit.CLUBS, 2, ActionCard.Type.BANG),
            new ActionCard(Card.Suit.CLUBS, 3, ActionCard.Type.BANG),
            new ActionCard(Card.Suit.CLUBS, 4, ActionCard.Type.BANG),
            new ActionCard(Card.Suit.CLUBS, 5, ActionCard.Type.BANG),
            new ActionCard(Card.Suit.CLUBS, 6, ActionCard.Type.BANG),
            new ActionCard(Card.Suit.CLUBS, 7, ActionCard.Type.BANG),
            new ActionCard(Card.Suit.CLUBS, 8, ActionCard.Type.BANG),
            new ActionCard(Card.Suit.CLUBS, 9, ActionCard.Type.BANG),
            new ActionCard(Card.Suit.DIAMONDS, 2, ActionCard.Type.BANG),
            new ActionCard(Card.Suit.DIAMONDS, 3, ActionCard.Type.BANG),
            new ActionCard(Card.Suit.DIAMONDS, 4, ActionCard.Type.BANG),
            new ActionCard(Card.Suit.DIAMONDS, 5, ActionCard.Type.BANG),
            new ActionCard(Card.Suit.DIAMONDS, 6, ActionCard.Type.BANG),
            new ActionCard(Card.Suit.DIAMONDS, 7, ActionCard.Type.BANG),
            new ActionCard(Card.Suit.DIAMONDS, 8, ActionCard.Type.BANG),
            new ActionCard(Card.Suit.DIAMONDS, 9, ActionCard.Type.BANG),
            new ActionCard(Card.Suit.DIAMONDS, 10, ActionCard.Type.BANG),
            new ActionCard(Card.Suit.DIAMONDS, 11, ActionCard.Type.BANG),
            new ActionCard(Card.Suit.DIAMONDS, Card.RANK_QUEEN, ActionCard.Type.BANG),
            new ActionCard(Card.Suit.DIAMONDS, Card.RANK_KING, ActionCard.Type.BANG),
            new ActionCard(Card.Suit.DIAMONDS, Card.RANK_ACE, ActionCard.Type.BANG),
            new ActionCard(Card.Suit.HEARTS, Card.RANK_QUEEN, ActionCard.Type.BANG),
            new ActionCard(Card.Suit.HEARTS, Card.RANK_KING, ActionCard.Type.BANG),
            new ActionCard(Card.Suit.HEARTS, Card.RANK_ACE, ActionCard.Type.BANG),
            new ActionCard(Card.Suit.SPADES, Card.RANK_ACE, ActionCard.Type.BANG),
            new ActionCard(Card.Suit.SPADES, 9, ActionCard.Type.DILIGENZA),
            new ActionCard(Card.Suit.SPADES, 9, ActionCard.Type.DILIGENZA),
            new ActionCard(Card.Suit.HEARTS, 3, ActionCard.Type.WELLS_FARGO),
            new ActionCard(Card.Suit.HEARTS, 10, ActionCard.Type.GATLING),
            new ActionCard(Card.Suit.HEARTS, 5, ActionCard.Type.SALOON),
            new ActionCard(Card.Suit.DIAMONDS, Card.RANK_ACE, ActionCard.Type.INDIANS),
            new ActionCard(Card.Suit.DIAMONDS, Card.RANK_KING, ActionCard.Type.INDIANS),
            new ActionCard(Card.Suit.CLUBS, 8, ActionCard.Type.DUEL),
            new ActionCard(Card.Suit.SPADES, 11, ActionCard.Type.DUEL),
            new ActionCard(Card.Suit.DIAMONDS, Card.RANK_QUEEN, ActionCard.Type.DUEL),
            new ActionCard(Card.Suit.HEARTS, Card.RANK_QUEEN, ActionCard.Type.PANIC),
            new ActionCard(Card.Suit.HEARTS, Card.RANK_ACE, ActionCard.Type.PANIC),
            new ActionCard(Card.Suit.HEARTS, 11, ActionCard.Type.PANIC),
            new ActionCard(Card.Suit.DIAMONDS, 8, ActionCard.Type.PANIC),
            new ActionCard(Card.Suit.DIAMONDS, 9, ActionCard.Type.CAT_BALOU),
            new ActionCard(Card.Suit.DIAMONDS, 10, ActionCard.Type.CAT_BALOU),
            new ActionCard(Card.Suit.DIAMONDS, 11, ActionCard.Type.CAT_BALOU),
            new ActionCard(Card.Suit.HEARTS, Card.RANK_KING, ActionCard.Type.CAT_BALOU),
            new ActionCard(Card.Suit.HEARTS, 6, ActionCard.Type.BEER),
            new ActionCard(Card.Suit.HEARTS, 7, ActionCard.Type.BEER),
            new ActionCard(Card.Suit.HEARTS, 8, ActionCard.Type.BEER),
            new ActionCard(Card.Suit.HEARTS, 9, ActionCard.Type.BEER),
            new ActionCard(Card.Suit.HEARTS, 10, ActionCard.Type.BEER),
            new ActionCard(Card.Suit.HEARTS, 11, ActionCard.Type.BEER),
            new ActionCard(Card.Suit.CLUBS, 3, ActionCard.Type.MISSED),
            new ActionCard(Card.Suit.CLUBS, 10, ActionCard.Type.MISSED),
            new ActionCard(Card.Suit.CLUBS, Card.RANK_ACE, ActionCard.Type.MISSED),
            new ActionCard(Card.Suit.CLUBS, Card.RANK_KING, ActionCard.Type.MISSED),
            new ActionCard(Card.Suit.CLUBS, Card.RANK_QUEEN, ActionCard.Type.MISSED),
            new ActionCard(Card.Suit.SPADES, 2, ActionCard.Type.MISSED),
            new ActionCard(Card.Suit.SPADES, 3, ActionCard.Type.MISSED),
            new ActionCard(Card.Suit.SPADES, 4, ActionCard.Type.MISSED),
            new ActionCard(Card.Suit.SPADES, 5, ActionCard.Type.MISSED),
            new ActionCard(Card.Suit.SPADES, 6, ActionCard.Type.MISSED),
            new ActionCard(Card.Suit.SPADES, 7, ActionCard.Type.MISSED),
            new ActionCard(Card.Suit.SPADES, 8, ActionCard.Type.MISSED),
            new ActionCard(Card.Suit.SPADES, Card.RANK_QUEEN, ActionCard.Type.SHOP),
            new ActionCard(Card.Suit.CLUBS, 9, ActionCard.Type.SHOP)
    ));

    public static List<Card> getShuffledCards() {
        var shuffledList = new ArrayList<>(list);
        Collections.shuffle(shuffledList);

        return shuffledList;
    }
}
