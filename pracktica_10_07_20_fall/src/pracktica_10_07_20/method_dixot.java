package pracktica_10_07_20;

public class method_dixot {
	static double f(float x){
	    double f;
	    return f = Math.cos(x);
	}
	 
	public static void main(String args[]){
	   //������ ����������� ������
	    float a,b,x = 0,c, eps = 0.000000001f ;
	    a = 0;
	    b = 1;
	    System.out.println(" cos(x)�� ��������� [0;1] ��� eps0.000000001");
	    System.out.println();
	    System.out.println("����� ���������: ");
	    
	 
	    
	    while ( Math.abs(a-b) > eps) {
	        c = (a+b)/2;
	        if (f(a) * f(c)<= 0) b = c;
	        else
	        {a = c;
	        x = (a+b)/2;}
	    }
	    System.out.println("x = " + x + " f(x) = " + f(x));
	    
	        
	    }
}
