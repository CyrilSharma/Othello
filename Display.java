import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
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

  public Display(String imgpath) {
    game = new Othello();
    icon = new ImageIcon(imgpath);

    myImage = new BufferedImage(
    icon.getIconWidth(),
    icon.getIconHeight(),
    BufferedImage.TYPE_INT_RGB);

    buffer = myImage.getGraphics();
    addMouseListener(new ClickListener());
  }

  public void paintComponent(Graphics g) {
    buffer.clearRect(0, 0, (int) getWidth(), (int) getHeight());
    imgData = ImageDrawer.drawScaledImage(icon.getImage(), this, buffer);
    drawBoardToBuffer();
    g.drawImage(myImage, 0, 0, icon.getImage().getWidth(null), icon.getImage().getHeight(null), null);
  }

  public void drawBoardToBuffer() {

    int state;
    int offset = (imgData.get_x2() - imgData.get_x1()) / 16;
    int boxSize = offset * 2;

    Piece p;
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        state = game.state(i, j);

        if (state != 0) {
          p = new Piece(i * boxSize + imgData.get_x1() + offset, j * boxSize + imgData.get_y1() + offset, 
          0.75 * boxSize, state);
          p.draw(buffer);
        }
      }
    }
  }

  public void move(int[] action) { // Cyril Sharma
    // Advances the internal game state, and updates the display
    // Also in charge of determining if move is legal
    // TBD: might probably trigger a pop-up to confirm the move

    if (game.legal(action))
      game.move(action);

    int state;
    int offset = (imgData.get_x2() - imgData.get_x1()) / 16;
    int boxSize = offset * 2;

    Piece p;
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        state = game.state(i, j);

        if (state != 0) {
          p = new Piece(i * boxSize + imgData.get_x1() + offset, j * boxSize + imgData.get_y1() + offset, 
          0.75 * boxSize, state);
          p.draw(buffer);
        }
      }
    }
    repaint();
  }

  private void reset() { // Sophia Lu
    // when the game is over, call this method if the player wishes to proceed to a
    // new game
    return;
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
      System.out.println("x: " + x);
      System.out.println("y: " + y);
      System.out.println("x1: " + imgData.get_x1());
      System.out.println("y1: " + imgData.get_y1());
      System.out.println("x2: " + imgData.get_x2());
      System.out.println("y2: " + imgData.get_y2());
      int boxSize = (imgData.get_x2() - imgData.get_x1()) / 8;
      int xCoord = ((int) x - imgData.get_x1()) / boxSize;
      int yCoord = ((int) y - imgData.get_y1()) / boxSize;
      System.out.println("xCoord: " + xCoord);
      System.out.println("yCoord: " + yCoord);
      int[] action = {xCoord, yCoord};
      move(action);
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
  }
}