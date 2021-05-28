
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
public class Display extends JLabel {
  /**
   * This class displays only the board, it does not display any of the interface
   * surrounding the board such as confirmation buttons
   * 
   * 
   * @param game: a class which handles othello game mechanics
   */

  // fields
  private BufferedImage myImage;
  private Graphics buffer;

  private Othello game;
  private ImageIcon icon;
  private ImageManager imgData;
  private boolean moved = false;
  private boolean current = true;
  private int[] current_action = null;

<<<<<<< HEAD
public Display(String imgpath) {
=======
  public Display(int gameIndex) throws IOException {
>>>>>>> bc81adaaa1c9b5dc68885edf35a407075ddbd24f
    game = new Othello();
    //icon = new ImageIcon( );
    
    Image img = ImageIO.read(new File("C:\\Sophia\\Test\\src\\slu\\othello.jpg"));   
    icon = new ImageIcon(img);
    
    int w = icon.getIconWidth();
    int h = icon.getIconHeight();

    myImage = new BufferedImage(
    icon.getIconWidth(),
    icon.getIconHeight(),
    BufferedImage.TYPE_INT_RGB);

    buffer = myImage.getGraphics();
    addMouseListener(new ClickListener());
    
    repaint();
  }

  public void paintComponent(Graphics g) {
    // Draw board
    buffer.setColor(Color.BLACK);
    buffer.fillRect(0, 0, (int) getWidth(), (int) getHeight());
    imgData = ImageDrawer.drawScaledImage(icon.getImage(), this, buffer);
    drawBoardToBuffer();

    // draw background
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, (int) getWidth(), (int) getHeight());

    // paste board onto background
    g.drawImage(myImage, 0, 0, icon.getImage().getWidth(null), icon.getImage().getHeight(null), null);
  }

  public void drawBoardToBuffer() {

    int state;
    int offset = (int) ((imgData.get_x2() - imgData.get_x1()) / 16.0);
    int boxSize = (int) ((imgData.get_x2() - imgData.get_x1()) / 8.0);

    Piece p;
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        state = game.getState(i, j);

        if (state != 0) {
          p = new Piece(i * boxSize + imgData.get_x1() + offset, j * boxSize + imgData.get_y1() + offset, 
          0.75 * boxSize, state);
          p.draw(buffer);
        }
      }
    }

    if (current_action != null) {
      p = new Piece(current_action[0] * boxSize + imgData.get_x1() + offset, current_action[1] * boxSize + imgData.get_y1() + offset, 0.75 * boxSize, 0);
      p.draw(buffer);
    }
  }

  public void traverse(int step) {
    // i.e if the player wants to retract a move they considered.
    if (step == -1 & moved == true) {
      current_action = null;
      game.unmove();
      moved = false;
    }
    else if (moved == false) {
      game.traverse(step);

      // if the game is at its latest position, set this value to true.
      current = game.current();
    }

    repaint();
  }


  public void move(int[] action) { // Cyril Sharma
    // Advances the internal game state, and updates the display
    // Also in charge of determining if move is legal
    // TBD: might probably trigger a pop-up to confirm the move

    if (moved || !current)
      return;

    if (game.legal(action)) {
      game.move(action);
      current_action = action;
      moved = true;
    }

    repaint();
  }

  public void finalize_move() {
    moved = false;
    current_action = null;
    repaint();
  }
  
  
  public boolean isOver() {
	  
	  return game.is_over();
  }

  
  public int[] getScore() {	  
	  return game.score();	  
  }
  
  
  public void reset() { // Sophia Lu
    // when the game is over, call this method if the player wishes to proceed to a
    // new game
    game.setDefaultState();   
  }

  private class ClickListener implements MouseListener // Cyril Sharma
  {
    // This will call the move method whenever a square is clicked

    public void mouseClicked(MouseEvent e) {    	
    }

    public void mousePressed(MouseEvent e) {
      Point coord = e.getPoint();
      double x = coord.getX();
      double y = coord.getY();
      int boxSize = (imgData.get_x2() - imgData.get_x1()) / 8;
      int xCoord = ((int) x - imgData.get_x1()) / boxSize;
      int yCoord = ((int) y - imgData.get_y1()) / boxSize;
      int[] action = {xCoord, yCoord};
      if (game.legal(action))
        move(action);
      
      repaint();
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
  }
}