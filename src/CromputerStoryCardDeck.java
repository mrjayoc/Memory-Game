
public class CromputerStoryCardDeck extends Deck {

/*    // Constructors
    public CromputerStoryCardDeck() {
        this(4, false);
    }

    public CromputerStoryCardDeck(boolean shouldBeShuffled) {
        this(4, shouldBeShuffled);
    }
    public CromputerStoryCardDeck(int numberOfCopies) {
        this(numberOfCopies,false);
    }*/

    public CromputerStoryCardDeck(int numberOfCards, int numberOfCopies, boolean shouldBeShuffled) {
        for (int i = 0; i < numberOfCopies; i++) {
            int j = 0;
            for (int k = 0; k < numberOfCards / numberOfCopies; k++) {
                if (j >= CromputerStoryCard.CHARACTER_VALUES.length) { j = 0; }
                CromputerStoryCard card = new CromputerStoryCard(CromputerStoryCard.CHARACTER_VALUES[j]);
                addCard(card);
                j++;
            }
        }
        if(shouldBeShuffled) shuffle();
    }
}