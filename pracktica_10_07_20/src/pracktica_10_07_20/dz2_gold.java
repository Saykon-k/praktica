package pracktica_10_07_20;

import java.util.ArrayList;
import java.util.Scanner;

public class dz2_gold {
	static float gold = (float) ((1+Math.sqrt(5))/2);

	static double f(double x){
	    double f;
	    return f = Math.cos(x);
	}
	//i=1 min i=-1 max
	public static ArrayList<double []> gold_find(int a1, int b1,double eps,int k,int i){
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
	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Введите начальное и конечное значение промежутка ");
		int a = scn.nextInt();
		int b = scn.nextInt();

	   	 ArrayList<double []> num = gold_find(a,b,0.000001,1000,1);
			System.out.format("На отрезке [%d;%d] функция cos принимает минимальное значение при x = %f y = %f \n"
					,a,b,num.get(num.size()-1)[0],f(num.get(num.size()-1)[0]));
		  num = gold_find(a,b,0.000001,1000,-1);
				System.out.format("На отрезке [%d;%d] функция cos принимает максимальное значение при x = %f y = %f \n"
						,a,b,num.get(num.size()-1)[0],f(num.get(num.size()-1)[0]));
	}
	
    


}
