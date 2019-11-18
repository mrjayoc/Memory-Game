package Model.Card;
import org.jetbrains.annotations.NotNull;

public class CromputerStoryCard extends Card {

    public static final String[] CHARACTER_VALUES  = {"Cromptous", "Chromebook Default", "Chromebook Disgust", "Sap Man", "Denis", "Jimbulo Bimbulor", "Lance", "Victorian Gentleman","SD Card", "Colossus", "Denie", "D-Money", "Meat Salesman" };
    private String character;

    public CromputerStoryCard(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return this.character;
    }

    @Override
    public String toString() {
        return character;
    }

    @Override
    public boolean equals(Object card) {
        if (card instanceof CromputerStoryCard) {
            CromputerStoryCard cromputerStoryCard = (CromputerStoryCard) card;
            return this.character.equals(cromputerStoryCard.getCharacter());
        } else {
            return super.equals(card);
        }
    }

    public int compareTo(@NotNull Card card) {
        CromputerStoryCard cromputerStoryCard = (CromputerStoryCard) card;
        return this.character.compareTo(cromputerStoryCard.getCharacter());
    }

}