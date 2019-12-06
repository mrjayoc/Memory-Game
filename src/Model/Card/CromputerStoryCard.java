package Model.Card;

public class CromputerStoryCard extends Card {
    private CHARACTER_VALUES character;

    public CromputerStoryCard(CHARACTER_VALUES character) {
        this.character = character;
    }

    public CHARACTER_VALUES getCharacter() {
        return this.character;
    }

    @Override
    public String toString() {
        return character.toString();
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

    public enum CHARACTER_VALUES {
        CROMPTOUS,
        CHROMEBOOK_DEFAULT,
        CHROMEBOOK_DISGUST,
        SAP_MAN,
        DENIS,
        JIMBULO_BIMBULOR,
        LANCE,
        VICTORIAN_GENTLEMAN,
        SD_CARD,
        COLOSSUS,
        DENIE,
        D_MONEY,
        MEAT_SALESMAN;
        }
}