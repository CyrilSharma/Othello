import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.JOptionPane;

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
   private BoardPanel bp;
   private JPanel subpanel;
   private JPanel tpanel;
   private JPanel titlescreen;

   public GamePanel()
   {
      // get tournament size from user then set number of torunament rounds to that number
      // using 1 as a dummy value
        setLayout(new BorderLayout());  
        
        tpanel = new JPanel();
        tpanel.setLayout(new FlowLayout());
        
        titlescreen = new JPanel();
        titlescreen.setLayout(new FlowLayout());
 
        JLabel title = new JLabel("Othello", SwingConstants.LEFT);
        title.setFont(new Font("Time", Font.PLAIN, 80));
        titlescreen.add(title);
        
        JButton start = new JButton("Start");
        start.addActionListener(new StartListener());
        tpanel.add(start);

        JButton rules = new JButton("Rules");
        rules.addActionListener(new RuleListener());
        tpanel.add(rules);
        
        add(titlescreen, BorderLayout.CENTER);
        add(tpanel, BorderLayout.SOUTH);

      int num_of_rounds = Integer.parseInt(JOptionPane.showInputDialog("How many rounds would you like to play?"));

      tournament = new Tournament(num_of_rounds);
      
       bp = new BoardPanel();
       bp.setSize(500, 500);
       bp.setLocation(0, 0);
       add(bp, BorderLayout.CENTER);
       bp.setVisible(false);
      
        subpanel = new JPanel();
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
    }
    private class StartListener implements ActionListener // Raka Adakroy
    {
        // This will initiate the game when the start button is clicked
        public void actionPerformed(ActionEvent e)
        {
        //    bp = new BoardPanel();
        //    add(bp, BorderLayout.CENTER);
            bp.setVisible(true);
            add(subpanel, BorderLayout.SOUTH);
            tpanel.setVisible(false);
            titlescreen.setVisible(false);
        }
    }

    private class RuleListener implements ActionListener // Raka Adakrooy
    {
        // This will open the rules for the game
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(null, "1. Black always moves first\n2. If on your turn, you can not flip at least one of your opponents discs, the game is a draw\n3. A disc may outflank any number of dics in any direction\n4. You may not skip over your own color to outflank an opposing disc\n5. Discs may only be outflanked as a direct result of a move");
        }
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
   
      private class ResetListener implements ActionListener
   {
      // This will play a new move, the difference between this and ForwardButtonListener is it will not advance the state to a previously explored state, it only advances the state to a new state.
      public void actionPerformed(ActionEvent e)
      {
         display.reset();
      }
   }
}