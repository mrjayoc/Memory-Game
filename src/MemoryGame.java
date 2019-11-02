import java.util.ArrayList;
import java.util.Arrays;

public abstract class MemoryGame {
    private ArrayList<Card> cardsMatched = new ArrayList<>();
    private int numberOfCardsToMatch;
    private Card[] cardsCurrentlyFlipped;
    private int numberOfCardsCurrentlyFlipped = 0;
    private Deck deck;
    private Card[] gameBoard;

    MemoryGame (int numberOfCardsToMatch, int sizeOfBoard) {

        if (numberOfCardsToMatch < 2) {
            throw new IllegalArgumentException("Number of cards to match must be greater than or equal to 2");
        }
        if (sizeOfBoard < numberOfCardsToMatch) {
            throw new IllegalArgumentException("Size of board must be greater than or equal to the number of cards to match");
        }
        if ((sizeOfBoard % numberOfCardsToMatch) != 0) {
            throw new IllegalArgumentException("Size of board must be a multiple of the number of cards being matched");
        }
        this.numberOfCardsToMatch = numberOfCardsToMatch;
        cardsCurrentlyFlipped = new Card[numberOfCardsToMatch];
        gameBoard = new Card[sizeOfBoard];
        deck = createDeck(sizeOfBoard, numberOfCardsToMatch);
        for (int i = 0; i < gameBoard.length; i++) {
            gameBoard[i] = deck.drawCard();
        }
    }

    MemoryGame (int sizeOfBoard) {
        this(2, sizeOfBoard);
    }

    protected abstract Deck createDeck(int numberOfCards, int numberOfCopies);

    public Card[] getCardsMatched() {
        return (Card[]) cardsMatched.toArray();
    }

    // TODO: Remove return value after implementing proper controller class
    public Card flipCardAt(int index) {
        Card card = gameBoard[index];
        card.flipCard();
        cardsCurrentlyFlipped[numberOfCardsCurrentlyFlipped++] = card;
        if (numberOfCardsCurrentlyFlipped == numberOfCardsToMatch) {
            System.out.println("Match result = " + matchCards());
        }
        return card;
    }

    public void removeCardAt(int index) {
        gameBoard[index] = null;
    }

    public void addCardAt(int index) {
        gameBoard[index] = deck.drawCard();
    }

    /**
     * @return true if the cards were matched, and false if they were not matched
     */
    private boolean matchCards() {
        // Using a for loop that counts backwards, so it grabs the card in the last index and compares it to the
        // card at index - 1. This made it easier to ensure to compare adjacent cards while avoiding an IndexOutOfBounds error
        for (int i = numberOfCardsToMatch - 1; i > 0; i--) {
            Card card1 = cardsCurrentlyFlipped[i];
            Card card2 = cardsCurrentlyFlipped[i - 1];
            if (!(isMatch(card1, card2))) {
                resetFlippedCards();
                return false;
            }
        }
        awardMatch();
        return true;
    }

    private void resetFlippedCards() {
        for (Card card : cardsCurrentlyFlipped) { card.flipCard(); }
        numberOfCardsCurrentlyFlipped = 0;
        cardsCurrentlyFlipped = new Card[numberOfCardsToMatch];
    }

    private void awardMatch() {
        cardsMatched.addAll(Arrays.asList(cardsCurrentlyFlipped));
        for (Card card : cardsCurrentlyFlipped) {
            removeCardAt(getIndexOfCard(card));
        }
        numberOfCardsCurrentlyFlipped = 0;
        cardsCurrentlyFlipped = new Card[numberOfCardsToMatch];
    }

    private boolean isMatch(Card card1, Card card2) {
        return card1.equals(card2);
    }
    
    private int getIndexOfCard(Card card) {
        for (int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[i] == card) return i;
        }
        return -1;
    }



}
