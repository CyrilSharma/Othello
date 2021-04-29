import javax.swing.*;
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

   public Display() {

   }
   public void move() { // Cyril Sharma
    // Advances the internal game state, and updates the display
    // Also in charge of determining if move is legal 
    // TBD: might probably trigger a pop-up to confirm the move
    return;
   }

   private void reset() {
    // when the game is over, call this method if the player wishes to proceed to a new game
    return;
 }
   private class ClickListener implements ActionListener // Cyril Sharma
   {
    // This will call the move method whenever a square is clicked
      public void actionPerformed(ActionEvent e)
      {
        move();
      }
   }
}