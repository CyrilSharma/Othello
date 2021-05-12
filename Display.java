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

  private static final int FRAME = FRAME;

  //fields
  private BufferedImage image;
  private Graphics buffer;
  private ImageIcon game_image;


   private Othello game;

   public Display() {
    game_image = new ImageIcon("othello.png");
    image =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_ARGB);
    buffer = image.getGraphics();
   }

   public void paintComponent(Graphics g)
   {
      buffer.drawImage(game_image.getImage(), 0, 0, FRAME, FRAME, null);
      move();
      g.drawImage(image, 0, 0, FRAME, FRAME, null);
   }

   public void drawBoardToBuffer() {
    buffer.drawImage(game_image.getImage(), 0, 0, FRAME, FRAME, null);

    int state;
    Piece p;
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        state = game.state(i, j);

        if (state != 0)
          p = new Piece(i, j, 10, state);
          p.draw(buffer);
      }
    }

    repaint();
  }

   public void move(int[] action) { // Cyril Sharma
    // Advances the internal game state, and updates the display
    // Also in charge of determining if move is legal 
    // TBD: might probably trigger a pop-up to confirm the move
    Piece p = new Piece(action[0], action[1], 100, 1);
    p.draw(buffer);
    repaint();
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