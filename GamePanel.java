import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.imageio.ImageIO;
public class GamePanel extends JPanel
{
   /**
    * This class displays and handles events within the entire GUI, complete with the board and button interactions
    * 
    * PRIVATE VARIABLES
    * 
    * display: class that handles solely the display of the board itself.
    * tournament: class that handles the winner of a sequence of repeated matches, also makes sure players get to be players 1 and 2 an even amount of times.

    * title: the title of the game
    */

   private Display display;
   private Tournament tournament;
   private JLabel title;

   public GamePanel()
   {
      // get tournament size from user then set number of torunament rounds to that number
      // using 1 as a dummy value
      tournament = new Tournament(1);

      setLayout(new GridBagLayout());
      GridBagConstraints c = new GridBagConstraints();

      display = new Display("othello.jpg");

      c.fill = GridBagConstraints.BOTH;
      c.anchor = GridBagConstraints.NORTHWEST;
      c.weighty = 0.75;
      c.weightx = 1.0;
      c.gridwidth = 1;
      c.gridheight = 1;
      c.gridx = 0;
      c.gridy = 0;

      display.setPreferredSize(new Dimension(1000, 1000));

      add(display, c);

      JPanel subpanel = new JPanel();
      subpanel.setLayout(new FlowLayout());

      JButton backward = new JButton("<-");
      backward.addActionListener(new BackButtonListener());
      subpanel.add(backward);

      JButton forward = new JButton("->");
      forward.addActionListener(new ForwardButtonListener());
      subpanel.add(forward);

      JButton move = new JButton("Move");
      move.addActionListener(new MoveListener());
      subpanel.add(move);

      c.fill = GridBagConstraints.HORIZONTAL;
      c.anchor = GridBagConstraints.CENTER;
      c.ipady = 0;
      c.gridx = 0;
      c.gridy = 1;
      c.weighty = 0.25;
      c.gridwidth = 1;   //2 columns wide
      c.gridheight = 1;


      add(subpanel, c);
      
      //tournament = new Tournament(1);
   }
   private class ForwardButtonListener implements ActionListener // Cyril Sharma
   {
      // This will advance the game state by one move when the button is clicked, but will only advance the gamestate to previous moves
      public void actionPerformed(ActionEvent e)
      {
         display.traverse(1);
         return;
      }
   }
   private class BackButtonListener implements ActionListener  //Sophia Lu 
   {
      // This will regress the game state by one move when the button is clicked
      public void actionPerformed(ActionEvent e)
      {
         display.traverse(-1);
         return;
      }
   }

   private class MoveListener implements ActionListener
   {
      // This will play a new move, the difference between this and ForwardButtonListener is it will not advance the state to a previously explored state, it only advances the state to a new state.
      public void actionPerformed(ActionEvent e)
      {
         display.finalize_move();
      }
   }
}