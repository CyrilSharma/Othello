import java.awt.Dimension;

import javax.swing.JFrame;
public class Driver {
   public static void main(String args[])
   {
      JFrame frame = new JFrame("Othello");

      frame.setSize(500, 500);
      frame.setLocation(200, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new GamePanel());
      frame.setMinimumSize(new Dimension(300, 300));
      frame.setVisible(true);
   }
}
