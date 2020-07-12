package pracktica_10_07_20;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class dz2_gold extends JComponent {
	static Scanner scn = new Scanner(System.in);
	static float a_real = scn.nextFloat();
	static float b_real = scn.nextFloat();
	static float gold = (float) ((1+Math.sqrt(5))/2);
	
	
	public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.scale(7, 7);
        //������� ������ ����������� ����� � ������������ ����������
        ArrayList<double []> num =gold_find(a_real,b_real,0.0001,1000,-1);//�������� �������
        ArrayList<double []> num1 =gold_find(a_real,b_real,001,1000,1);//�������
        //��������� ������
        Stroke stroke = new BasicStroke(0.25f);
        g2.setStroke(stroke);
        //����������� �������
        for(double i = -100; i<1000;i+=0.001) {
            g2.setStroke(stroke);
        	g2.draw(new Line2D.Double(i+200, 100-f(i), i+200+0.001, 100-f(i+0.001)));
        }
        
        
        //�������� �������
        double x1 = num.get(num.size()-1)[0];
        double y1 = f(num.get(num.size()-1)[0]);
        Stroke stroke1 = new BasicStroke(0.25f);
        g2.setStroke(stroke1);
        g2.setColor(Color.ORANGE);
        //������������ �����
        g2.draw(new Line2D.Double(200+x1, 0,200+x1, 440));
        //��������������
        Stroke stroke2 = new BasicStroke(0.25f);
        g2.setStroke(stroke2);
        g2.setColor(Color.ORANGE);
        g2.draw(new Line2D.Double(0,100-y1,440,100-y1));
        
        //������� ������� 
        double x1m = num1.get(num1.size()-1)[0];
        double y1m = f(num1.get(num1.size()-1)[0]);
        g2.setStroke(stroke1);
        g2.setColor(Color.GREEN);
        g2.draw(new Line2D.Double(200+x1m, 0,200+x1m, 440));
        g2.setStroke(stroke2);
        g2.setColor(Color.GREEN);
        g2.draw(new Line2D.Double(0,100-y1m,440,100-y1m));
        
        //����������� ���� 0� � 0�
        g2.setColor(Color.black);
        g2.draw(new Line2D.Double(0,100,420,100));
        g2.draw(new Line2D.Double(200,0,200,440));
       
       //����������� 
       String s = "������� ������� y = " + Double.toString(f(num1.get(num1.size()-1)[0]));
       Font myFont = new Font ("Courier New", 1, 2);
       g.setFont (myFont);
       g2.drawString(s, 0, 2);
       String s1 = "������� ������� x = " + Double.toString(num1.get(num1.size()-1)[0]);
       g2.drawString(s1, 0, 5);

       s = "�������� ������� y = " + Double.toString(f(num.get(num.size()-1)[0]));
       g.setFont (myFont);
       g2.drawString(s, 0, 8);
       s1 = "�������� ������� x = " + Double.toString(num.get(num.size()-1)[0]);
       g2.drawString(s1, 0, 11);

       //g2.draw(new Line2D.Double(200,0,440,440));

    }

	static double f(double x){
	    return  Math.sqrt(x)+1/x;
	}
	//i=1 min i=-1 max
	public static ArrayList<double []> gold_find(float a1, float b1,double eps,int k,int i){
   	 ArrayList<double []> num = new ArrayList<double []>();
   	 float x1,x2,y1,y2;
   	 float a = a1, b = b1;
   	 int k1 = 0;
   	 while (Math.abs(b - a) > eps || k1<k){
   		 	k1++;
            x1 = b - (b - a) / gold;
            x2 = a + (b - a) / gold;
            y1 =(float) f(x1) ;
            y2 = (float) f(x2);
            if (y1 * i  >= y2 * i ) { a = x1; } else { b = x2; }
            double srez [] = { a,b};
            num.add(srez);
	    }
	    double x [] = {(a+b)/2};
	    num.add(x);
	    return num;

   }
	public static void main(String args[]){
        JFrame frame = new JFrame("Draw Line");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new dz2_gold());
        frame.pack();
        frame.setSize(new Dimension(420, 440));
        frame.setVisible(true);
	}
}
