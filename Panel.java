import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Panel extends JPanel
{
   /**
    * This class displays and handles events within the entire GUI, complete with the board and button interactions
    * 
    * PRIVATE VARIABLES
    * 
    * display: class that handles solely the display of the board itself.
    * title: the title of the game
    */
   private Display display;
   private JLabel title;

   public Panel()
   {

   }
   private class ForwardButtonListener implements ActionListener
   {
      // This will advance the game state by one move when the button is clicked, but will only advance the gamestate to previous moves
      public void actionPerformed(ActionEvent e)
      {
         return;
      }
   }
   private class BackButtonListener implements ActionListener
   {
      // This will regress the game state by one move when the button is clicked
      public void actionPerformed(ActionEvent e)
      {
         return;
      }
   }

   private class MoveListener implements ActionListener
   {
      // This will play a new move, the difference between this and ForwardButtonListener is it will not advance the state to a previously explored state, it only advances the state to a new state.
      public void actionPerformed(ActionEvent e)
      {
         return;
      }
   }
}