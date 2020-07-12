package pracktica_10_07_20;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class dz3_fib {
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
	    return  4*Math.pow(x,2)+23/x;
	}
	public static ArrayList<double []> fib_find(int a1, int b1,int n,int i){
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
		Scanner scn = new Scanner(System.in);
		System.out.println("Введите начальное и конечное значение промежутка ");
		int a = scn.nextInt();
		int b = scn.nextInt();
		System.out.println("Введите количество итераций");
		int n = scn.nextInt();

	   	 ArrayList<double []> num = fib_find(a,b,n,1);
			System.out.format("На отрезке [%d;%d] функция x^2 принимает минимальное значение при x = %f y = %f \n"
					,a,b,num.get(num.size()-1)[0],f(num.get(num.size()-1)[0]));
		  num = fib_find(a,b,n,-1);
				System.out.format("На отрезке [%d;%d] функция x^2 принимает максимальное значение при x = %f y = %f \n"
						,a,b,num.get(num.size()-1)[0],f(num.get(num.size()-1)[0]));
				System.out.println(Fib_n(0));
	}
}
