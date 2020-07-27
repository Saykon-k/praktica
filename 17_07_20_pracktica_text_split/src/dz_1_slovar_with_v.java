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
		FileReader fr  = new FileReader("C:\\Users\\lenov\\git\\praktica\\17_07_20_pracktica\\words.txt");
	     Scanner scan = new Scanner(fr);
	     ArrayList<String> dict = new ArrayList<String>();
	     HashMap<String, Double  > dict1 = new HashMap<String,Double >();
	     double i1 = 0;
	     int i = 1;
	     //���������� � ������� �����
	     while (scan.hasNextLine()) {
	         i++;
	         String s[] = scan.nextLine().split(" ");
	        	 dict.add(s[0]);
	        	 dict1.put(s[0],Double.parseDouble(s[1]));
	        	 i1 += Double.parseDouble(s[1]);
	         }
	     fr.close();
	     String s = "mencoldwhite";
	     System.out.println("������� ����� " + s);
	     char [] slovobychar = s.toCharArray();
	     bidirectional_algorithm(dict,slovobychar,dict1,i1);
	     
	    }
public static void maximum_match(ArrayList<String> dict , 
		char[] slovobychar,ArrayList<String> words,double k,   HashMap<String,Double>  dict1,Double all ) {
		String s = "";
		//������� ����, ������� ������� � �������� � ������ 
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

					//����������� �����, ������� ���� � ������ � �� ������� 
					wordspovtor.put(s, (double) i);
				}
				i++;
			}
			//��������� �����,������� ��� � �������
			if(remeber1==0) {
				if(remeber+1 >= slovobychar.length) {
					break;
				}
				k++;
				//��������� ����� � ������� � �������� 1 
				vvv.add((double) 1);
				words.add(String.valueOf(slovobychar[(int) remeber]));
				remeber++;
				max = "";
				i = remeber;
				s="";
			}else {
			//�������� sravn - ���������� �����, ������� ������ �������� - ������ �������� ����� ����������� - ����� ���������� �� 
			//������� ���,� �������� ���������� ������� ���������� � ������. ������ ���������� � ����
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
		System.out.println("���������� �������������");
		System.out.println(vvv.toString());
		System.out.println(words.toString());
		words.add(Double.toString(ver(vvv,all)));
		//System.out.println(ver(vvv,all));

	}
public static void Reverse_algorithm(ArrayList<String> dict ,
		char[] slovobychar,ArrayList<String> words,double k1,   HashMap<String,Double>  dict1,Double all ) {
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
		//��������� �����,������� ��� � �������
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
			//�������� sravn - ���������� �����, ������� ������ �������� - ������ �������� ����� ����������� - ����� ���������� �� 
			//������� ���,� �������� ���������� ������� ���������� � ������. ������ ���������� � ����
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
	//System.out.println(wordspovtor.toString());
	System.out.println("���������� ��������� ���������");
	System.out.println("������� "+ vvv.toString());
	System.out.println(words.toString());
	words.add(Double.toString(ver(vvv,all)));
	//System.out.println(ver(vvv,all));
}
	public static String[] sravn(HashMap<String,Double> dict1,HashMap<String,Double> wordspovtor ) {
		double cravn  = -1;
		String Doubles = "";
		//������� �������� ������ � �� �������. ��������� � �������� ������ 
		for(Entry<String, Double> r : wordspovtor.entrySet()) {
			String pr = r.getKey();
			System.out.println(pr +" "+dict1.get(pr));
			if(dict1.get(pr)>cravn) {
				cravn = dict1.get(pr);
				Doubles = pr;
			}
		}
		//���� �����,������ � ������� ������� �������� 
		String o [] =  { Doubles,Double.toString(wordspovtor.get(Doubles)),Double.toString(cravn)};		
		return o;
	}
	public static double ver(ArrayList<Double> k,Double all) {
		double j = 1;
		for(Double i : k ) j*=(i/all);
		return j;
	}
	public static ArrayList<String> bidirectional_algorithm(ArrayList<String> dict,char[] slovobychar,HashMap<String,Double>  dict1,double i1) {
		ArrayList<String> words = new ArrayList<String>();
	    int k = 0,k1=0;
	     maximum_match(dict,slovobychar,words,0,dict1,i1);
	    ArrayList<String> words1 = new ArrayList<String>();
	     Reverse_algorithm(dict,slovobychar,words1,0,dict1,i1);
	    //��������� ������� �������� ����������� �������� ��������� ��������
	    if(Double.parseDouble(words.get(words.size()-1))==Double.parseDouble(words1.get(words1.size()-1)) ) {
			System.out.println("��������� �������� ���������� ���������");
	    	return words;
	    }
		if(Double.parseDouble(words.get(words.size()-1))<Double.parseDouble(words1.get(words1.size()-1))) {
			System.out.println("�������� ������������� ������������ ��� ������ �����������");
			return words;
		}else {
			System.out.println("�������� �������� ������������� ��� ������ �����������");
			return words1;

		}
		
	}
	}

