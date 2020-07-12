package pracktica_10_07_20;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class dz3_fib extends JComponent{
	static Scanner scn = new Scanner(System.in);
	static float a_real = scn.nextFloat();
	static float b_real = scn.nextFloat();
	static float gold = (float) ((1+Math.sqrt(5))/2);

	public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.scale(7, 7);
        ArrayList<double []> num =fib_find(a_real,b_real,10,-1);//максимум функции
        ArrayList<double []> num1 =fib_find(a_real,b_real,10,1);//минимум
        //настройка шрифта
        Stroke stroke = new BasicStroke(0.25f);
        g2.setStroke(stroke);
        //отображение фукнции
        for(double i = -100; i<1000;i+=0.001) {
            g2.setStroke(stroke);
        	g2.draw(new Line2D.Double(i+200, 100-f(i), i+200+0.001, 100-f(i+0.001)));
        }
        
        //максимум функции
        double x1 = num.get(num.size()-1)[0];
        double y1 = f(num.get(num.size()-1)[0]);
        Stroke stroke1 = new BasicStroke(0.25f);
        g2.setStroke(stroke1);
        g2.setColor(Color.ORANGE);
        //вертикальная линия
        g2.draw(new Line2D.Double(200+x1, 0,200+x1, 440));
        //горизонтальная
        Stroke stroke2 = new BasicStroke(0.25f);
        g2.setStroke(stroke2);
        g2.setColor(Color.ORANGE);
        g2.draw(new Line2D.Double(0,100-y1,440,100-y1));
        
        //минимум функции 
        double x1m = num1.get(num1.size()-1)[0];
        double y1m = f(num1.get(num1.size()-1)[0]);
        g2.setStroke(stroke1);
        g2.setColor(Color.GREEN);
        g2.draw(new Line2D.Double(200+x1m, 0,200+x1m, 440));
        g2.setStroke(stroke2);
        g2.setColor(Color.GREEN);
        g2.draw(new Line2D.Double(0,100-y1m,440,100-y1m));
        
        //отображение осей 0х и 0у
        g2.setColor(Color.black);
        g2.draw(new Line2D.Double(0,100,420,100));
        g2.draw(new Line2D.Double(200,0,200,440));
       
       //отображение 
       String s = "минимум функции y = " + Double.toString(f(num1.get(num1.size()-1)[0]));
       Font myFont = new Font ("Courier New", 1, 2);
       g.setFont (myFont);
       g2.drawString(s, 0, 2);
       String s1 = "минимум функции x = " + Double.toString(num1.get(num1.size()-1)[0]);
       g2.drawString(s1, 0, 5);

       s = "Максимум функции y = " + Double.toString(f(num.get(num.size()-1)[0]));
       g.setFont (myFont);
       g2.drawString(s, 0, 8);
       s1 = "Максимум функции x = " + Double.toString(num.get(num.size()-1)[0]);
       g2.drawString(s1, 0, 11);

       //g2.draw(new Line2D.Double(200,0,440,440));

    }
	public static double Fib_n(int n) {
		int a = 1;
		int b = 1;
		for (int i = 2; i <= n; ++i) {
		    int next = a + b;
		    a = b;
		    b = next;
		}
		return b;
	}
	static double f(double x){
	    return  Math.pow(x,0.5);
	}
	public static ArrayList<double []> fib_find(float a1, float b1,int n,int i){
	   	 ArrayList<double []> num = new ArrayList<double []>();
	   	 double x1 =0,x2 = 0,y1,y2;
	   	 double a = a1 ,b = b1;
	   	 for(;n>1;n--) {
	   		 x1 = a+(b-a)*Fib_n(n-2)/Fib_n(n);
	   		 x2 = a+(b-a)*Fib_n(n-1)/Fib_n(n);
	   		 y1 = f(x1);
	   		 y2 = f(x2);
	   		 if(y1*i>y2*i) {
	   			 a = x1;
	   			 x1 = x2;
	   			 x2 = b - (x1-a);
	   		 }else {
	   			 b = x2;
	   			 x2 = x1;
	   			 x1 = a + (b-x2);
	   		 }
	   	 }
	   	 double x[]  = {(x1+x2)/2};
	   	 	num.add(x);
		    return num;
	}
	public static void main(String args[]) {

        JFrame frame = new JFrame("Draw Line");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new dz3_fib());
        frame.pack();
        frame.setSize(new Dimension(420, 440));
        frame.setVisible(true);
	}
}
