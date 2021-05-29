
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TitlePanel extends JPanel
{

    /**
     * This class displays an starting screen, so you don't immediately start a game
     * 
     * PRIVATE VARIABLES
     * 
     * title: just a title for the loading screen
     */

    private JLabel title = new JLabel("Othello");
    JPanel subpanel;

    public TitlePanel() { //Raka Adakroy
        setLayout(new BorderLayout());
        title.setFont(new Font("Time", Font.PLAIN, 16));
        add(title, BorderLayout.CENTER);

        subpanel = new JPanel();
        subpanel.setLayout(new FlowLayout());

        JButton start = new JButton("Start");
        start.addActionListener(new StartListener());
        subpanel.add(start);

        JButton rules = new JButton("Rules");
        rules.addActionListener(new RuleListener());
        subpanel.add(rules);

        add(subpanel, BorderLayout.SOUTH);
    }

    private class StartListener implements ActionListener // Raka Adakroy
    {
        // This will initiate the game when the start button is clicked
        public void actionPerformed(ActionEvent e)
        {
//        	subpanel.setVisible(false);
//        	title.setVisible(false);
        	JComponent comp = (JComponent) e.getSource();
        	comp.getParent().getParent().setVisible(false);
        	
        }
    }

    private class RuleListener implements ActionListener // Raka Adakrooy
    {
        // This will open the rules for the game
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(null, "1. Black always moves first\n2. If on your turn, you can not flip at least one of your opponents discs, you have to pass\n3. A disc may outflank any number of dics in any direction\n4. You may not skip over your own color to outflank an opposing disc\n5. Discs may only be outflanked as a direct result of a move");
        }
    }
}