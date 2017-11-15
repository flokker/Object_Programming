package GUI;

import javax.swing.*;
import javax.swing.JComponent;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Location extends JButton   //15*5 rectangle
{
   private Image image;
   private Point location;
   public Location() {
      image = Toolkit.getDefaultToolkit().getImage("src/test/Slat 60X20.png");
      MediaTracker tracker = new MediaTracker(this);
      tracker.addImage(image, 0);
      try {
         tracker.waitForID(0);
      }
      catch(InterruptedException exception) {}
      location = new Point(1, 1);
   }
   
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      if(image == null) return;

      g.drawImage(image, 0, 0, null);
   }
   
   public void setLocation(int i, int j) {
      location.x = i;
      location.y = j;
   }
   
   public Point getLocation() {
      return location;
   }

}