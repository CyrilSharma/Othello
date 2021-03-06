
import javax.swing.*;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

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
   private int gameIndex = 0;

   public GamePanel() throws IOException
   {
      // get tournament size from user then set number of torunament rounds to that number
      // using 1 as a dummy value
           
      TitlePanel titlePanel = new TitlePanel();
      titlePanel.setLayout(new FlowLayout());
      add(titlePanel);

      int num_of_rounds = Integer.parseInt(JOptionPane.showInputDialog("How many rounds would you like to play?"));

      tournament = new Tournament(num_of_rounds);
            
      setLayout(new GridBagLayout());
      // setPreferredSize(new Dimension(400, 400));

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
      
      JButton reset = new JButton("Reset");
      reset.addActionListener(new ResetListener());
      subpanel.add(reset);

      c.fill = GridBagConstraints.HORIZONTAL;
      c.anchor = GridBagConstraints.CENTER;
      c.ipady = 0;
      c.gridx = 0;
      c.gridy = 1;
      c.weighty = 0.25;
      c.gridwidth = 1;   //2 columns wide
      c.gridheight = 1;


      add(subpanel, c);
      
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
         tournament.setScore(gameIndex, display.getScore()); 
         
         if (display.isOver())
         {
        	   gameIndex ++;
            int winnerPlayer = tournament.getWinner();        		 
            
            if (winnerPlayer == 1)
               showMessageDialog(null, "Player 1 is the winner");
            
            if (winnerPlayer == 2)
               showMessageDialog(null, "Player 2 is the winner");
            
            display.reset("othello.jpg");
         }
      }
   }
   
      private class ResetListener implements ActionListener
   {
      // This will play a new move, the difference between this and ForwardButtonListener is it will not advance the state to a previously explored state, it only advances the state to a new state.
      public void actionPerformed(ActionEvent e)
      {
         display.reset("othello.jpg");
         return;
      }
   }
}