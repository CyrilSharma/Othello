import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

public class BoardPanel extends JPanel {

   private Display display; 
    
    public BoardPanel() { //Raka Adakroy
       
        
      setLayout(new GridBagLayout());
      GridBagConstraints c = new GridBagConstraints();

      display = new Display("othello.jpg");

      c.fill = GridBagConstraints.BOTH;
      c.anchor = GridBagConstraints.NORTHWEST;
      c.weighty = 0.75;
      c.weightx = 1.0;
      c.gridwidth = 1;
      c.gridheight = 1;
      c.gridx = 0;
      c.gridy = 0;

      display.setPreferredSize(new Dimension(1000, 1000));

      add(display, c);  
      }
}
