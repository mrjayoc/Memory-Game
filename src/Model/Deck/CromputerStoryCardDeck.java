package Model.Deck;
import Model.Card.CromputerStoryCard;

public class CromputerStoryCardDeck extends Deck {

    public CromputerStoryCardDeck(int numberOfCards, int numberOfCopies, boolean shouldBeShuffled) {
        for (int i = 0; i < numberOfCopies; i++) {
            int j = 0;
            for (int k = 0; k < numberOfCards / numberOfCopies; k++) {
                if (j >= CromputerStoryCard.CHARACTER_VALUES.values().length) { j = 0; }
                CromputerStoryCard card = new CromputerStoryCard(CromputerStoryCard.CHARACTER_VALUES.values()[j]);
                addCard(card);
                j++;
            }
        }
        if(shouldBeShuffled) shuffle();
    }
}