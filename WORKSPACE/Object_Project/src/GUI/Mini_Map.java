package GUI;


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;


public class Mini_Map extends JPanel {
   public Location [][] locker;
   public static int current;      // 1st floor < 0, 2nd floor > 0 and not use 0
   private Image image;
   private static final int space1 = 5;
   private static final int space2 = 10;
   private static final int space3 = 15;
   private static final int button_width = 60;
   private static final int button_height = 20;
   
   public Mini_Map() {
      int i, j;
      locker = new Location[2][];
      for(i = 0; i < 2; i++) {
         locker[i] = new Location[5];
         for(j = 0; j < 5; j++) 
            locker[i][j] = new Location();
         
      }
      setLayout(null);
      for(i = 0; i < 2; i++) {
         for(j = 0; j < 5; j++) {
            locker[i][j].setSize(button_width, button_height);
            if(i == 0) {
               if(j < 3) {
                  locker[i][j].setLocation(space3+(button_width+space2)*j, space3+120);
               }
               else {
                  locker[i][j].setLocation(space3+(button_width+space2)*(j%3), space3+(button_height+button_width)+120);
               }
            }
            else {
               if(j < 4) {
                  locker[i][j].setLocation(space3+(button_width+space2)*j, space3);
               }
               else {
                  locker[i][j].setLocation(space3, space3+(button_height+button_width));
               }
            }
            locker[i][j].setLocation(i, j);
            add(locker[i][j]);
            locker[i][j].addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  JButton b = (JButton)e.getSource();
                  current = b.getLocation().y;
                  if(b.getLocation().x == 1)
                     current *= -1;
               }
            }
            );
         }
      }
      image = Toolkit.getDefaultToolkit().getImage("src/test/Stairs.png");
      MediaTracker tracker = new MediaTracker(this);
      tracker.addImage(image, 0);
      try {
         tracker.waitForID(0);
      }
      catch(InterruptedException exception) {}
      current = -1;
   }
   
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      
      double width = 290;
      double height = 120;
      
      Rectangle2D rect1 = new Rectangle2D.Double(space1, space1, width, height);
      g2.draw(rect1);
      
      Rectangle2D rect2 = new Rectangle2D.Double(space1, 2*space1 + height, width, height);
      g2.draw(rect2);
      
      
      if(image == null) return;
      
      g.drawImage(image, 155, 130, null);
   }
}

class ButtonAction_Mini implements ActionListener{
   public ButtonAction_Mini() {
      
   }
   
   public void actionPerformed(ActionEvent e) {
      JButton b = (JButton)e.getSource();
      
   }
}

/*
 * key push - up -> if you are on first floor, you displace to second floor.
 * key push - down -> if you are on second floor, you displace to first floor.
 * key push - left -> left move
 * key push - right -> right move
 */

class KeyHandler extends KeyAdapter
{
	Mini_Map p;
   public void keyReleased(KeyEvent e) {
      int keyCode = e.getKeyCode();
      
      switch(keyCode) {
      case KeyEvent.VK_UP:
         if(p.current < 0) p.current = 1; break;
      case KeyEvent.VK_DOWN:
         if(p.current > 0) p.current = -1; break;
      case KeyEvent.VK_LEFT:
         if(p.current > 0) if(--p.current == 0) p.current = 5;
         else if(p.current < 0) if(++p.current == 0) p.current = -1;
      case KeyEvent.VK_RIGHT:
         if(p.current > 0) if(++p.current == 6)   p.current = 1;
         else if(p.current < 0) if(--p.current == -1) p.current = -1;
         break;
      }
   }
}