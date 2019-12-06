package Model.MemoryGame.CromputerStoryMemoryGame;

import Model.Card.Card;
import Model.Card.CromputerStoryCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CromputerStoryMemoryGameTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void getCardsMatched() {
    }

    @Test
    void flipCardAt() {
        CromputerStoryMemoryGame game = new CromputerStoryMemoryGame(2,26);
        Object flippedCard = null;
        try {
            flippedCard = game.flipCardAt(0);
        } catch (Exception e) {
            fail("flipCardAtIndex in CromputerStoryCard is supposed return a card. Check to make sure it is not a void return type.",e);
        } finally {
            assertTrue(flippedCard instanceof String, "When flipping card in CromputerStorMemoryGame it did not get a CromputerStoryCard in return");
        }


    }

    @Test
    void createDeck() {


    }
}