import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Panel extends JPanel
{
   /**
    * This class displays and handles events within the entire GUI, complete with the board, titlescreen and button interactions
    * 
    * PRIVATE VARIABLES
    * 
    * display: class that handles solely the display of the board itself.
    * tournament: class that handles the winner of a sequence of repeated matches, also makes sure players get to be players 1 and 2 an even amount of times.

    * title: the title of the game
    */

   private Display display;
   private TitleScreen titleScreen;
   private Tournament tournament;
   private JLabel title;

   public Panel()
   {
      // get tournament size from user then set number of torunament rounds to that number
      // using 1 as a dummy value

      setLayout(new GridBagLayout());
      GridBagConstraints c = new GridBagConstraints();

      display = new Display();
      c.fill = GridBagConstraints.BOTH;
      c.anchor = GridBagConstraints.LINE_END;
      c.ipady = 100;      //make this component tall
      c.weighty = 0.75;
      c.weightx = 1.0;
      c.gridwidth = 1;
      c.gridheight = 1;
      c.gridx = 0;
      c.gridy = 0;

      add(display, c);

      JPanel subPanel = new JPanel();
      subPanel.add(new JButton("HELLO!"));
      c.fill = GridBagConstraints.HORIZONTAL;
      c.anchor = GridBagConstraints.CENTER;
      c.ipady = 0;
      c.gridx = 0;
      c.gridy = 1;
      c.weighty = 0.25;
      c.gridwidth = 1;   //2 columns wide
      c.gridheight = 1;


      add(subPanel, c);
      //tournament = new Tournament(1);

   }

   private class ForwardButtonListener implements ActionListener // Cyril Sharma
   {
      // This will advance the game state by one move when the button is clicked, but will only advance the gamestate to previous moves
      public void actionPerformed(ActionEvent e)
      {
         return;
      }
   }
   private class BackButtonListener implements ActionListener  // Sophia Lu 
   {
      // This will regress the game state by one move when the button is clicked
      public void actionPerformed(ActionEvent e)
      {
         return;
      }
   }

   private class MoveListener implements ActionListener // Raka Adakroy
   {
      // This will play a new move, the difference between this and ForwardButtonListener is it will not advance the state to a previously explored state, it only advances the state to a new state.
      public void actionPerformed(ActionEvent e)
      {
         display.move();
      }
   }
}