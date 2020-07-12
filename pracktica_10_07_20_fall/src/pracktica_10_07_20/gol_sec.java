package pracktica_10_07_20;

public class gol_sec {
	static double f(double x){
	    double f;
	    return f = Math.cos(x);
	}
	public static void main(String args[]) {
		// задание начальные данные
	    float a,b,x1,x2,y1,y2 = 0,c, eps = 0.0000001f ;
	    float gold = (float) ((1+Math.sqrt(5))/2);
	    System.out.println(gold);
	    //интервал от 0 до 1 
	    a = 0;
	    b = 1;
	    while (Math.abs(b - a) > eps){
            x1 = b - (b - a) / gold;
            x2 = a + (b - a) / gold;
            y1 =(float) f(x1) ;
            y2 = (float) f(x2);
            if (y1 >= y2)
                a = x1;
            else
                b = x2;
	    }
	    float x = (a+b)/2;
	    System.out.println("x = " + x + " f(x) = " + f(x));

	}
}

