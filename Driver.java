
import java.awt.Dimension;

import java.io.IOException;

import javax.swing.JFrame;
public class Driver {
   public static void main(String args[]) throws IOException
   {
      JFrame frame = new JFrame("Othello");
      //Display display = new Display("");
      frame.setSize(500, 500);
      frame.setLocation(200, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new GamePanel());
      //frame.setContentPane(new Display(""));
      frame.setMinimumSize(new Dimension(300, 300));
      frame.setVisible(true);
   }
}
