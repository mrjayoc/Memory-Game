import Model.MemoryGame.MemoryGame;

import javax.swing.*;

public class MemoryGameViewController {

    private MemoryGameView gameView;
    private MemoryGame gameModel;

    public MemoryGameViewController() {
        JFrame frame = new JFrame("MemoryGameViewController");
       // frame.setContentPane((new MemoryGameView()).rootPanel);
        frame.setDefaultCloseOperation(3);
        frame.pack();
        frame.setVisible(true);
    }
}
