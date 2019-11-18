package Model.Card;

public abstract class Card implements Comparable<Card> {

    private boolean isFaceUp;

    public void flipCard() {
        isFaceUp = !isFaceUp;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

}
