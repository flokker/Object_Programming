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
   private static final int space1 = 1;
   private static final int space2 = 8;
   private static final int space3 = 4;
   private static final int button_width = 60;
   private static final int button_height = 20;
   
   public Mini_Map() {
      int i, j;
      locker = new Location[2][];
      for(i = 0; i < 2; i++) {
         locker[i] = new Location[10];
         for(j = 0; j < 10; j++) 
            locker[i][j] = new Location();
         
      }
      setLayout(null);
      for(i = 0; i < 2; i++) {
         for(j = 0; j < 10; j++) {
            locker[i][j].setSize(button_width, button_height);
            if(i == 0) {
               if(j < 6) {
                  locker[i][j].setLocation(space3+(button_width+space2)*j, space3+83);
               }
               else {
                  locker[i][j].setLocation(space3+(button_width+space2)*(j%6), space3+(button_height*3)+83);
               }
            }
            else {
               if(j < 7) {
                  locker[i][j].setLocation(space3+(button_width+space2)*j, space1);
               }
               else {
                  locker[i][j].setLocation(space3+(button_width+space2)*(j%7), space1+(button_height*3));
               }
            }
            locker[i][j].setPosition(i, j);
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
      current = -1;
   }
   
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      
      double width = 476;
      double height = 82;
      
      Rectangle2D rect1 = new Rectangle2D.Double(space1, space1, width, height);
      g2.draw(rect1);
      
      Rectangle2D rect2 = new Rectangle2D.Double(space1, 3*space1 + height, width, height);
      g2.draw(rect2);
      
      
      if(image == null) return;
      
      g.drawImage(image, 314, 436, null);
   }
}

class ButtonAction_Mini implements ActionListener{
   public ButtonAction_Mini() {
      
   }
   
   public void actionPerformed(ActionEvent e) {
      JButton b = (JButton)e.getSource();
      
   }
}

/**
 * @since 2017-11-14
 * @author Yongho Kim
 * @description
 * key push - up -> if you are on first floor, you displace to second floor.
 * key push - down -> if you are on second floor, you displace to first floor.
 * key push - left -> left move
 * key push - right -> right move
 **/

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
         if(p.current > 0) if(--p.current == 0) p.current = 9;
         else if(p.current < 0) if(++p.current == 0) p.current = -9;
      case KeyEvent.VK_RIGHT:
         if(p.current > 0) if(++p.current == 10)   p.current = 1;
         else if(p.current < 0) if(--p.current == -10) p.current = -1;
         break;
      }
   }
}