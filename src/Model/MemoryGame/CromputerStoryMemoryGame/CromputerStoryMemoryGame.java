package Model.MemoryGame.CromputerStoryMemoryGame;
import Model.Deck.CromputerStoryCardDeck;
import Model.Deck.Deck;
import Model.MemoryGame.MemoryGame;

public class CromputerStoryMemoryGame extends MemoryGame {

    public CromputerStoryMemoryGame(int numberOfCardsToMatch, int sizeOfBoard) {
        super(numberOfCardsToMatch, sizeOfBoard);
    }

    @Override
    protected Deck createDeck(int numberOfCards, int numberOfCopies) {
        return new CromputerStoryCardDeck(numberOfCards, numberOfCopies, true);
    }

}
