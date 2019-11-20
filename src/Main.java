import Model.Card.CromputerStoryCard;
import Model.MemoryGame.CromputerStoryMemoryGame;

import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        CromputerStoryMemoryGame game = new CromputerStoryMemoryGame(2, 26);
        while (true) {
            CromputerStoryCard card = (CromputerStoryCard) game.flipCardAt(readInt("What card do you want to flip?"));
            System.out.println("card = " + card);
        }
    }

    private static int readInt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextInt();
    }
}