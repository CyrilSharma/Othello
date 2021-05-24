import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MainPanel extends JPanel {

    public MainPanel() { //Raka Adakroy
        setLayout(new CardLayout());

        final String INTRO_PANEL = "Card with JButtons";
        final String GAME_PANEL = "Card with JTextField";
        
        JPanel introCard = new TitlePanel();
        JPanel gameCard = new GamePanel();

        add(introCard, INTRO_PANEL);
        add(gameCard, GAME_PANEL);

    }
}

private class StartListener implements ActionListener  //Sophia Lu 
{
    // This will regress the game state by one move when the button is clicked
    public void actionPerformed(ActionEvent e)
    {
        
        return;
    }
}
