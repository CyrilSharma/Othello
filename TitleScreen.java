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
        return;
        }
    }

    private class RuleListener implements ActionListener // Raka Adakrooy
    {
        // This will open the rules for the game
        public void actionPerformed(ActionEvent e)
        {
        return;
        }
    }
}