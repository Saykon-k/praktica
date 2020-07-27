package pracktica_10_07_20;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class dz1_methdo_dixot extends JComponent {
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.scale(3, 3);
        //for(double i = 0; i<1000;i+=0.01) g2.draw(new Line2D.Double(i, 100-Math.sin(i), i+1, 100-Math.sin(i)));
    }
 

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Line");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new dz1_methdo_dixot());
        frame.pack();
        frame.setSize(new Dimension(420, 440));
        frame.setVisible(true);
    }
}