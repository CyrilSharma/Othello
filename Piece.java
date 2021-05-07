// Billington.  email: mlbillington@fcps.edu
// version: 7.25.2007
// updated by Phil Ero 16NOV07

import java.awt.*;

public class Piece
{
   private double xPos;   // x and y coordinates of center
   private double yPos;
   private double diameter;
   private Color color; 

  // constructors
   public Piece()     //default constructor
   {
      xPos = 200;
      yPos = 200;
      diameter = 25;
      color = Color.RED;
   }
   public Piece(double x, double y, double d, Color c)
   {
      xPos = x;
      yPos = y;
      diameter = d;
      color = c;
   }
    // modifier methods
   public void setX(double x)
   {
      xPos = x;
   } 
   public void setY(double y)
   {
      yPos = y;
   } 
   public void setColor(Color c)
   {
      color = c;
   }
   public void setDiameter(double d)
   {
      diameter = d;
   }
 //	 instance methods
   public void jump(int rightEdge, int bottomEdge)
   {
      // moves location to random (x, y) within the edges
      xPos = (Math.random()* (rightEdge-diameter) + diameter / 2);
      yPos = (Math.random()* (bottomEdge-diameter) + diameter / 2);
   }
   public void draw(Graphics buffer) 
   {
      buffer.setColor(color);
      buffer.fillOval((int)(xPos - diameter / 2), (int)(yPos - diameter / 2), (int) diameter, (int) diameter);
   }
}