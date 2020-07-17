import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class dz_1_slovar_with_v {

	public static void main(String[] args) throws IOException {
		FileReader fr  = new FileReader("C:\\Users\\lenov\\Desktop\\words.txt");
	     Scanner scan = new Scanner(fr);
	     ArrayList<String> dict = new ArrayList<String>();
	     HashMap<String, Double  > dict1 = new HashMap<String,Double >();
	     double i1 = 0;
	     int i = 1;
	     int i3 = 0;
	     //записываем в словарь слова
	     while (scan.hasNextLine()) {
	         i++;
	         String s[] = scan.nextLine().split(" ");
	        	 dict.add(s[0]);
		        
	        	 dict1.put(s[0],Double.parseDouble(s[1]));
	        	 i1 += Double.parseDouble(s[1]);
	        	 i3++;
//	        if (i == 5000) {
//	        	break;
//	        }
	   
	         }

	     System.out.println(i3);
	     fr.close();
	     String s = "themenan";
	     System.out.println("входное слово " + s);
	     char [] slovobychar = s.toCharArray();
	 	ArrayList<String> words = new ArrayList<String>();
	     maximum_match(dict,slovobychar,words,0,dict1,i1);
	     System.out.println(dict1.get("a"));
	    }
public static void maximum_match(ArrayList<String> dict , char[] slovobychar,ArrayList<String> words,int k,   HashMap<String,Double>  dict1,Double all ) {
		String s = "";
		//словарь слов, которые нашлись в процессе и индекс 
		HashMap<String,Double> wordspovtor = new HashMap<String,Double>();
		ArrayList<Double> vvv = new ArrayList<Double>();

		String []sravn_var = new String[3];
		double i = 0; 
		double remeber = 0;
		String max ="";
		int remeber1 = 0;
		while(remeber < slovobychar.length ) {
			
			while(i < slovobychar.length) {
				s+=slovobychar[(int) i];
				if(dict.indexOf(s)!= -1) {
					max = s;
					remeber = i;
					remeber1=4;
					//сохраняем элементы, которые есть в строке и их индекс 
					//System.out.println(s+" "+dict1.get(s));
					
					wordspovtor.put(s, (double) i);
				}
				i++;
			}
			//проверяем буквы,которых нет в словаре
			if(remeber1==0) {
				if(remeber+1 >= slovobychar.length) {
					break;
				}
				k++;
				vvv.add((double) 1);
				words.add(String.valueOf(slovobychar[(int) remeber]));
				remeber++;
				max = "";
				i = remeber;
				s="";
			}else {
			sravn_var = sravn(dict1,wordspovtor);
			max = sravn_var[0];
			remeber = Double.parseDouble(sravn_var[1]);
			vvv.add(Double.parseDouble(sravn_var[2]));
			wordspovtor.clear();
			words.add(max);
			i = remeber+1;
			s="";
			max = "";
			remeber1 = 0;
			}
		}
		
//		System.out.println(wordspovtor.toString());
		System.out.println(vvv.toString());
		System.out.println(words.toString());
		words.add(Integer.toString(k));
		System.out.println(ver(vvv,all));

	}
public static void Reverse_algorithm(ArrayList<String> dict , char[] slovobychar,ArrayList<String> words,int k1,   HashMap<String,Double>  dict1,Double all ) {
	String s = "";
	HashMap<String,Double> wordspovtor = new HashMap<String,Double>();
	ArrayList<Double> vvv = new ArrayList<Double>();

	String []sravn_var = new String[3];
	//ArrayList<String> words = new ArrayList<String>();
	double i = slovobychar.length-1; 
	double remeber = slovobychar.length-1;
	String max ="";
	double remeber1 = 0;
	while(remeber > -1) {
		while(i > -1) {
			s=  slovobychar[(int) i]+s;
			if(dict.indexOf(s)!= -1) {
				max = s;
				remeber = i;
				remeber1=4;
				wordspovtor.put(s, (double) i);

			}
			i--;
		}
		//проверяем буквы,которых нет в словаре
		if(remeber1==0) {
			if(remeber-1 < 0) {
				break;
			}
			vvv.add((double) 1);
			words.add(String.valueOf(slovobychar[(int) remeber]));
			remeber--;
			max = "";
			k1++;
			i = remeber;
			s="";
		}else {
			sravn_var = sravn(dict1,wordspovtor);
			max = sravn_var[0];
			remeber = Double.parseDouble(sravn_var[1]);
			vvv.add(Double.parseDouble(sravn_var[2]));
			wordspovtor.clear();
		words.add(max);
		i = remeber-1;
		s="";
		max = "";
		remeber1 = 0;
		}

	}
	System.out.println(wordspovtor.toString());
	System.out.println(vvv.toString());
	System.out.println(words.toString());
	words.add(Integer.toString(k1));
	System.out.println(ver(vvv,all));
}
	public static String[] sravn(HashMap<String,Double> dict1,HashMap<String,Double> wordspovtor ) {
		double cravn  = -1;
		String Doubles = "";
		for(Entry<String, Double> r : wordspovtor.entrySet()) {
			String pr = r.getKey();
			System.out.println(pr +" "+dict1.get(pr));
			if(dict1.get(pr)>cravn) {
				cravn = dict1.get(pr);
				Doubles = pr;
			}
		}
		//само слово,индекс и частота встречи элемента 
		String o [] =  { Doubles,Double.toString(wordspovtor.get(Doubles)),Double.toString(cravn)};		
		return o;
	}
	public static double ver(ArrayList<Double> k,Double all) {
		double j = 1;
		for(Double i : k ) j*=(i/all);
		return j;
	}
	}

