import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Display extends JPanel
{
    /**
     * This class displays only the board, 
     * it does not display any of the interface surrounding the board such as confirmation buttons
     * 
     * PRIVATE VARIABLES
     * 
     * game: a class which handles othello game mechanics
     */
   private Othello game;

   public Display()
   {

   }
   public void move()
   {
    // Advances the internal game state, and updates the display
    // TBD: might probably trigger a pop-up to confirm the move
    return;
   }
   private class ClickListener implements ActionListener
   {
    // This will call the move method whenever a square is clicked
      public void actionPerformed(ActionEvent e)
      {
        move();
      }
   }
}