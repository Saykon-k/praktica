package praktica_09_07_20;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class test_speed_methods {
	 public static void main(String args[]) {
	    	Scanner scn = new Scanner(System.in);
	    	int vvod = scn.nextInt();
	        if (auth(vvod)) {
	        	System.out.println("Да,автоморфное "+vvod+" Ваше число в квадрате "+vvod*vvod+" совпадает на конце.");
	        }else {
	        	System.out.println("Нет,автоморфное "+vvod+" Ваше число в квадрате "+vvod*vvod + " не совпадает.");
	
	        }
	    	long countD = 0,countS = 0,countS1 = 0 ;
	        long l [] = new long [50_000_000];
	        for(int i = 0; i < 50_000_000; i++) l[i]=i;
	        long time = timer(() -> {
	
	        for(int i = 0; i < 50_000_000; i++) prov(l[i]);
	        }, TimeUnit.NANOSECONDS);
	        countD+= time;
	        //System.out.println(time+" без строк");
	        
	        
	        
	        time = timer(() -> {
	
	            for(int i = 0; i < 50_000_000; i++) prov1(l[i]);
	            }, TimeUnit.NANOSECONDS);
	        countS+= time;
	
	          //  System.out.println(time+" со строками");
	            
	            
	         time = timer(() -> {
	                for(int i = 0; i < 50_000_000; i++) prov2(l[i]);
	                }, TimeUnit.NANOSECONDS);
	         countS1+= time;
	          //System.out.println(time+" со строками + еще Integer.parse int");
	        System.out.println(countD+" время работы функции auth");
	        System.out.println(countS+" время работы функции str");
	    	int a  = 12_890_625;
	        System.out.println(str(a));



	    }
	    public static boolean str(long num) {
	    	String str = Long.toString(num*num);
	    	String str1 = Long.toString(num);
	    	return str.substring(str.length()-str1.length()).equals(str1)
	    			;
	    } 	
	    public static boolean str1(long num) {
	    	String str = Long.toString(num*num);
	    	String str1 = Long.toString(num);
	    	return Integer.parseInt(str.substring(str.length()-str1.length())) == num
	    			;
	    } 	
	    public static int countDigits(long num) {
	        int ket = 1;
	        while ((num /= 10) != 0) ket++
	        ;
	        return ket;
	    }
	    public static boolean auth(long num) {
	        return (num * num) % Math.pow(10, countDigits(num)) == num;
	    }
	    public static String prov(long vvod) {
	        if (auth(vvod)) {
	        	//System.out.println("Да,автоморфное "+vvod+" Ваше число в квадрате "+vvod*vvod+" совпадает на конце.");
	        	return null;
	        }else {
	        	//System.out.println("Нет,автоморфное "+vvod+" Ваше число в квадрате "+vvod*vvod + " не совпадает.");
	        	return null;
	        }
	    }
	    public static String prov1(long vvod) {
	        if (str(vvod)) {
	        	//System.out.println("Да,автоморфное "+vvod+" Ваше число в квадрате "+vvod*vvod+" совпадает на конце.");
	        	return null;
	        }else {
	        	//System.out.println("Нет,автоморфное "+vvod+" Ваше число в квадрате "+vvod*vvod + " не совпадает.");
	        	return null;
	        }
	    }
	    public static String prov2(long vvod) {
	        if (str1(vvod)) {
	        	//System.out.println("Да,автоморфное "+vvod+" Ваше число в квадрате "+vvod*vvod+" совпадает на конце.");
	        	return null;
	        }else {
	        	//System.out.println("Нет,автоморфное "+vvod+" Ваше число в квадрате "+vvod*vvod + " не совпадает.");
	        	return null;
	        }
	    }
	    private static long timer(Runnable method, TimeUnit timeUnit) {
	        long time = System.nanoTime();
	        method.run();
	        time = System.nanoTime() - time;
	        return TimeUnit.NANOSECONDS.convert(time, timeUnit);
	    }
}
