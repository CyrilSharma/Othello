import java.awt.*;

public class Piece {
    private double xPos;
    private double yPos;
    private double diameter;
    private Color color;

    public Piece(double x, double y, double d, int player) {
        xPos = x;
        yPos = y;
        diameter = d;

        if (player == 1)
            color = Color.BLACK;
        else if (player == -1)
            color = Color.WHITE;
        else
            // transparent
            color = new Color(0,0,0,0);
    }

    // modifier methods
    public void setPos(double x, double y) {
        xPos = x;
        yPos = y;
    }

    public void setColor(int state_val) {
        if (state_val == 1)
            color = Color.BLACK;
        else if (state_val == -1)
            color = Color.WHITE;
        else
            // transparent
            color = new Color(0,0,0,0);
    }

    public void setDiameter(double d) {
        diameter = d;
    }

    public void draw(Graphics buffer) {
        buffer.setColor(color);
        buffer.fillOval((int) (xPos - diameter / 2), (int) (yPos - diameter / 2), (int) diameter, (int) diameter);
    }
}