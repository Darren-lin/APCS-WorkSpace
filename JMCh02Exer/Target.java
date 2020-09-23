// Question 2-13-a

import java.awt.*;
import javax.swing.*;

/**
 *  This program displays a red cross on a white
 *  background.
 */

public class Target extends JPanel
{
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method
                              //   to paint the background
    int xCenter = getWidth() / 2;
    int yCenter = getHeight() / 2;
    g.setColor( Color.RED );
    g.fillOval(xCenter - 35, yCenter - 40, 70, 70);
    g.setColor( Color.WHITE );
    g.fillOval( xCenter - 22,  yCenter - 27,  45,  45 );
    g.setColor(Color.RED);
    g.fillOval(xCenter - 10, yCenter - 15, 20, 20);
    
  }

  public static void main(String[] args)
  {
    JFrame window = new JFrame("Red Cross");
    window.setBounds(300, 300, 200, 200);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Target panel = new Target();
    panel.setBackground(Color.WHITE);
    Container c = window.getContentPane();
    c.add(panel);
    window.setVisible(true);
  }
}

