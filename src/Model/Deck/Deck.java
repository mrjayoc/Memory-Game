package Model.Deck;

import Model.Card.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public abstract class Deck {
    private ArrayList<Card> cards = new ArrayList<>();

    public void sort() {
        cards.sort(null);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int cardCount() {
        return cards.size();
    }

    public Card drawCard() {
        return drawCardAt(0);
    }

    public Card drawRandomCard() {
        Random randNumGenerator = new Random();
        int index = randNumGenerator.nextInt(cards.size());
        return drawCardAt(index);
    }
    private Card drawCardAt(int index) {
        return cards.remove(index);
    }
}