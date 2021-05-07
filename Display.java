import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class Display extends JPanel
{
  /**
   * This class displays only the board, 
   * it does not display any of the interface surrounding the board such as confirmation buttons
   * 
   * 
   * @param game: a class which handles othello game mechanics
   */

  private static final int FRAME = 400;

  //fields
  private BufferedImage image;
  private JLabel label;
  private Graphics buffer;
  private ImageIcon game_image;


   private Othello game;

   public Display() {
    label = new JLabel();
    label.setIcon(new ImageIcon("othello.png"));
    add(label);

    image =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
    buffer = image.getGraphics();
   }

   public void paintComponent(Graphics g)
   {
      g.drawImage(image, 0, 0, FRAME, FRAME, null);
   }

   public void move() { // Cyril Sharma
    // Advances the internal game state, and updates the display
    // Also in charge of determining if move is legal 
    // TBD: might probably trigger a pop-up to confirm the move

    //buffer.drawImage(.getImage(), xPos, yPos, null);

    //repaint();

    return;
   }

   private void reset() {   //Sophia Lu 
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