package Model.MemoryGame;

import Model.Card.Card;
import Model.Deck.Deck;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class MemoryGame {
    private ArrayList<Card> cardsMatched = new ArrayList<>();
    private int numberOfCardsToMatch;
    private Card[] cardsCurrentlyFlipped;
    private int numberOfCardsCurrentlyFlipped = 0;
    private Card[] gameBoard;

    MemoryGame (int numberOfCardsToMatch, int sizeOfBoard) {
        /* Checking the arguments of the constructor to make sure they are valid
           We cannot have a matching game with less 2 cards to match, if the size of the board has less cards than
           the number of cards to match, or if the size of the board isn't a multiple of the number of cards we are going
           to match.
         */
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
        Deck deck = createDeck(sizeOfBoard, numberOfCardsToMatch);
        for (int i = 0; i < gameBoard.length; i++) {
            gameBoard[i] = deck.drawCard();
        }
    }

    MemoryGame (int sizeOfBoard) {
        this(2, sizeOfBoard);
    }

    /**
     * An abstract method that will create a new {@code Deck} when implemented in the concrete subclass.
     * Because the <code>MemoryGame</code> is abstract and is used as a framework for any Memory Game,
     * it isn't aware of what type of cards should be in the deck it uses. This allows the constructor
     * of <code>MemoryGame</code> to utilize a <code>Deck</code>, but have the concrete subclass provide
     * the <code>Deck</code> that should be used.
     * <p>
     * This method should create a <code>Deck</code> that contains cards that are a subclass of <code>Card</code>
     * </p>
     * @param numberOfCards The total number of cards that will be in the deck
     * @param numberOfCopies The number of copies of each card value
     * @return  A {@code Deck} that will contain cards. The size of the deck will match {@code numberOfCards}
     *          and the number of copies of each card value will match {@code numberOfCopies}
     */
    protected abstract Deck createDeck(int numberOfCards, int numberOfCopies);

    /**
     * Returns an array of type <code>Card</code> of all the cards that have been matched by the player.
     * This is essentially the player's pile of collected cards.
     * @return An array of type <code>Card</code> of the cards the player has matched
     */
    public Card[] getCardsMatched() {
        return (Card[]) cardsMatched.toArray();
    }

    /**
     * 
     * @param index
     * @return
     */
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

    /**
     * Removes a card from the game board at a specific index.
     * @param index The index value of the card that should be removed from the game board
     */
    private void removeCardAt(int index) {
        gameBoard[index] = null;
    }

    /**
     * Attempts to match all the currently flipped cards. This is called once the
     * <code>numberOfCardsFlipped</code> matches <code>numberOfCardsToMatch</code>
     * @return <code>true</code> if the cards were matched, and <code>false</code> if they were not matched
     */
    private boolean matchCards() {
        /*  Using a for loop that counts backwards, so it grabs the card in the last index and compares it to the
            card at index - 1. This made it easier to compare adjacent cards while avoiding an 
            IndexOutOfBounds error
         */
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

    /**
     * Flips back over all cards currently flips and resets the {@code numberOfCardsCurrentlyFlipped}
     * and {@code cardsCurrentlyFlipped} variables.
     */
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

    /**
     * Checks if two cards are equal to each other.
     * This method simply enhances the semantics where this method is called.
     * This method makes it very clear that the two cards are bing checked for equality
     * because we want to know if they are a match or not.
     * @param card1
     * @param card2
     * @return
     */
    private boolean isMatch(Card card1, Card card2) {
        return card1.equals(card2);
    }

    /**
     * Finds the what index number on the game board of a specific card.
     * This will return -1 for the index if it does not find the specific card
     * @param card  The specific card being searched for on the game board
     * @return  The index value of the card, or -1 if the card was not found
     */
    private int getIndexOfCard ( Card card) {
        for (int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[i] == card) return i;
        }
        return -1;
    }



}
