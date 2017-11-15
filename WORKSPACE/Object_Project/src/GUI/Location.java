package GUI;

import javax.swing.*;
import javax.swing.JComponent;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Location extends JButton   //15*5 rectangle
{
   private Image image;
   private Point position;
   public Location() {
      image = Toolkit.getDefaultToolkit().getImage("./Img/Slat.png");
      MediaTracker tracker = new MediaTracker(this);
      tracker.addImage(image, 0);
      try {
         tracker.waitForID(0);
      }
      catch(InterruptedException exception) {}
      position = new Point(1, 1);
   }
   
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      if(image == null) return;

      g.drawImage(image, 0, 0, null);
   }
   
   public void setPosition(int i, int j) {
      position.x = i;
      position.y = j;
   }
   
   public Point getPosition() {
      return position;
   }

}