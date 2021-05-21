import javax.swing.*;
import java.awt.event.*;

public class TitleScreen extends JPanel
{

    /**
     * This class displays an starting screen, so you don't immediately start a game
     * 
     * PRIVATE VARIABLES
     * 
     * title: just a title for the loading screen
     */

    private JLabel title;

    public TitleScreen() {

    }

    private class StartListener implements ActionListener // Raka Adakroy
    {
        // This will initiate the game when the start button is clicked
        public void actionPerformed(ActionEvent e)
        {
            JFrame frame = new JFrame("Othello");

            frame.setSize(500, 500);
            frame.setLocation(200, 100);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new Panel());
            frame.setVisible(true);
        }
    }

    private class RuleListener implements ActionListener // Raka Adakrooy
    {
        // This will open the rules for the game
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(null, "1. Black always moves first\n2. If on your turn, you can not flip at least one of your opponents discs, the game is a draw\n3. A disc may outflank any number of dics in any direction\n4. You may not skip over your own color to outflank an opposing disc\n5. Discs may only be outflanked as a direct result of a move");;
        }
    }
}