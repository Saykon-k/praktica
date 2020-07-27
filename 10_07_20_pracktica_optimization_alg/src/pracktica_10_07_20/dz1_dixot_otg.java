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
public class dz1_dixot_otg extends JComponent {
	static Scanner scn = new Scanner(System.in);
	static float a_real = scn.nextFloat();
	static float b_real = scn.nextFloat();
	static float gold = (float) ((1+Math.sqrt(5))/2);
	
	
	public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.scale(7, 7);
        //входные данные вычисляются здесь и записываются и отрисовываются
        ArrayList<double []> num =dixotpoint(a_real,b_real,0.0001,1000,-1);//максимум функции
        ArrayList<double []> num1 =dixotpoint(a_real,b_real,001,1000,1);//минимум
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
       Font myFont = new Font ("Courier New", 1, 5);
       g.setFont (myFont);
       g2.drawString(s, 0, 5);
       String s1 = "минимум функции x = " + Double.toString(num1.get(num1.size()-1)[0]);
       g2.drawString(s1, 0, 10);

       s = "Максимум функции y = " + Double.toString(f(num.get(num.size()-1)[0]));
       g.setFont (myFont);
       g2.drawString(s, 0, 15);
       s1 = "Максимум функции x = " + Double.toString(num.get(num.size()-1)[0]);
       g2.drawString(s1, 0, 20);

       //g2.draw(new Line2D.Double(200,0,440,440));

    }
	   public static double f(double x) {
	    	return Math.pow(x, 2)+1;
	    }
	   //первые два параметра отрезок
	   //третий ошибка четвертный количество итераций 
	   // i = -1 поиск максимума i = 1 поиск максимума
	    public static ArrayList<double []> dixotpoint(float a, float b,double eps,int k,int i){
	    	ArrayList<double []> num = new ArrayList<double []>();
	    	double a_fake = a;
	    	double b_fake = b;
	    	int k1 = 0;
	    	while (Math.abs(b_fake - a_fake)>eps || k1< k ) {
	    		k1++;
	    		double x  = (b_fake + a_fake)/2;
	    		double F1 = f(x-eps);
	    		double F2 = f(x+eps);
	    		if(i*F1<i*F2) {
	    			b_fake = x;
	    		}else {
	    			a_fake = x;
	    		}
	    		double[] srez = {a_fake,b_fake};
	    		num.add(srez);
	    	}
			double[] srez = {(a_fake+b_fake)/2};
			num.add(srez);
	    	return num;
	    }

	public static void main(String[] args) {
        JFrame frame = new JFrame("Draw");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new dz1_dixot_otg());
        frame.pack();
        frame.setSize(new Dimension(420, 440));
        frame.setVisible(true);
	}

}
