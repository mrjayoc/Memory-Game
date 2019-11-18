import javax.swing.*;
import java.awt.*;

public class MemoryGameViewController {
    private JPanel rootPanel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        LayoutManager layoutManager = new GridLayout();
        rootPanel.setLayout(layoutManager);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MemoryGameViewController");
        frame.setContentPane(new MemoryGameViewController().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
