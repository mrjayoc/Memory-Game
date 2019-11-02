public class CromputerStoryMemoryGame extends MemoryGame {

    CromputerStoryMemoryGame (int numberOfCardsToMatch, int sizeOfBoard) {
        super(numberOfCardsToMatch, sizeOfBoard);
    }

    @Override
    protected CromputerStoryCardDeck createDeck(int numberOfCards, int numberOfCopies) {
        return new CromputerStoryCardDeck(numberOfCards, numberOfCopies, true);
    }

}
