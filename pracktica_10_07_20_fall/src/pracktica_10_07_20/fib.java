package pracktica_10_07_20;

public class fib {
	static double f(float x){
	    double f;
	    return f = (x*x-1)*(x*x-1)-3;
	}
	static int fibonachi(int n){
		 
	    if (n == 0){
	        return 0;
	    }
	    if (n == 1){
	        return 1;
	    }
	    else{
	        return fibonachi(n - 1) + fibonachi(n - 2);
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
