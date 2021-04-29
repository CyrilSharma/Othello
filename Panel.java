//Name______________________________ Date_____________
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Panel extends JPanel
{
   private Display08 display;
   private JLabel sum;
   public Panel()
   {
      setLayout(new BorderLayout());
   
      display = new Display08();
      add(display, BorderLayout.CENTER);
      
      JPanel subpanel = new JPanel();
      subpanel.setLayout(new GridLayout(4, 2));
      add(subpanel, BorderLayout.SOUTH);
       
      JButton finite = new JButton("Finite");             //Create and add JButton to the panel
      finite.addActionListener(new Listener1());
      subpanel.add(finite);
    
      JButton infinite = new JButton("Infinite");          //Create and add JButton to the panel
      infinite.addActionListener(new Listener2());
      subpanel.add(infinite);
   
   }
   private class Listener1 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         display.sumFinite();
      }
   }
   private class Listener2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         display.sumInfinite();
      }
   }
}