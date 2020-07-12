package pracktica_10_07_20;

import java.util.ArrayList;

public class dz1_dixot_otg {
	
	   public static double f(double x) {
	    	return Math.sin(x);
	    }
	   //первые два параметра отрезок
	   //третий ошибка четвертный количество итераций 
	   // i = -1 поиск максимума i = 1 поиск максимума
	    public static ArrayList<double []> dixotpointmax(int a, int b,double eps,int k,int i){
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
		ArrayList<double []> num =dixotpointmax(0,7,0.0001,1000,-1);
		System.out.format("На отрезке [%d;%d] функция sin принимает максимальное значение при x = %f y = %f \n"
				,0,7,num.get(num.size()-1)[0],f(num.get(num.size()-1)[0]));
		ArrayList<double []> num1 =dixotpointmax(0,7,0.0001,1000,1);
		System.out.format("На отрезке [%d;%d] функция sin принимает минимальное значение при x = %f y = %f "
				,0,7,num1.get(num1.size()-1)[0],f(num1.get(num1.size()-1)[0]));
	}

}
