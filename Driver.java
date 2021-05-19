import javax.swing.JFrame;
public class Driver {
   public static void main(String args[])
   {
      JFrame frame = new JFrame("Othello");
      frame.setSize(215, 250);
      frame.setLocation(200, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new Panel());
      frame.setVisible(true);
   }
}
