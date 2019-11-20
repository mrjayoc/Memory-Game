package Model.Card;

public abstract class Card {

    private boolean isFaceUp;

    public void flipCard() {
        isFaceUp = !isFaceUp;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

}
