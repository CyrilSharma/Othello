import javax.swing.JFrame;
public class Driver {
    public static void main(String args[])
    {
        JFrame frame = new JFrame("Othello");
        frame.setSize(200, 200);
        frame.setLocation(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Panel());
        frame.setVisible(true);
    }
}