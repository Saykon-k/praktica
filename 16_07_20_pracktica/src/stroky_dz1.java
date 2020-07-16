import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class stroky_dz1 {

public static void main(String[] args) throws IOException {
	 FileReader fr  = new FileReader("C:\\Users\\lenov\\Desktop\\1000.txt");
     Scanner scan = new Scanner(fr);
     ArrayList<String> dict = new ArrayList<String>();
     int i = 1;
     //записываем в словарь слова
     while (scan.hasNextLine()) {
         
         i++;
        	 dict.add(scan.nextLine().split("	")[0]);
        	 
         }
     
     fr.close();
     String s = "wordallmenonesswim";
     System.out.println("входное слово " + s);
     char [] slovobychar = s.toCharArray();
     bidirectional_algorithm(dict,slovobychar);
     
    } 
public static void maximum_match(ArrayList<String> dict , char[] slovobychar,ArrayList<String> words,int k ) {
	String s = "";
	//ArrayList<String> words = new ArrayList<String>();
	int i = 0; 
	int remeber = 0;
	String max ="";
	int remeber1 = 0;
	while(remeber < slovobychar.length) {
		
		while(i < slovobychar.length) {
			s+=slovobychar[i];
			if(dict.indexOf(s)!= -1) {
				max = s;
				remeber = i;
				remeber1=4;
			}
			i++;
		}
		//проверяем буквы,которых нет в словаре
		if(remeber1==0) {
			if(remeber+1 >= slovobychar.length) {
				break;
			}
			k++;
			words.add(String.valueOf(slovobychar[remeber]));
			remeber++;
			max = "";
			i = remeber;
			s="";
		}else {
		words.add(max);
		i = remeber+1;
		s="";
		max = "";
		remeber1 = 0;
		}
	}
	
	words.add(Integer.toString(k));

}
public static void Reverse_algorithm(ArrayList<String> dict , char[] slovobychar,ArrayList<String> words,int k1) {
	String s = "";
	//ArrayList<String> words = new ArrayList<String>();
	int i = slovobychar.length-1; 
	int remeber = slovobychar.length-1;
	String max ="";
	int remeber1 = 0;
	while(remeber > -1) {
		while(i > -1) {
			s=  slovobychar[i]+s;
			if(dict.indexOf(s)!= -1) {
				max = s;
				remeber = i;
				remeber1=4;
			}
			i--;
		}
		//проверяем буквы,которых нет в словаре
		if(remeber1==0) {
			if(remeber-1 < 0) {
				break;
			}
			words.add(String.valueOf(slovobychar[remeber]));
			remeber--;
			max = "";
			k1++;
			i = remeber;
			s="";
		}else {
		words.add(max);
		i = remeber-1;
		s="";
		max = "";
		remeber1 = 0;
		}
	}
	words.add(Integer.toString(k1));

}
public static ArrayList<String> bidirectional_algorithm(ArrayList<String> dict,char[] slovobychar) {
	ArrayList<String> words = new ArrayList<String>();
    int k = 0,k1=0;
    maximum_match(dict,slovobychar,words,k);
    ArrayList<String> words1 = new ArrayList<String>();
    Reverse_algorithm(dict,slovobychar,words1,k1);
    //последний элемент является количеством символов, которых нет в словаре
    System.out.println(words.toString());
    System.out.println(words1.toString());
    if(Integer.parseInt(words.get(words.size()-1))==Integer.parseInt(words1.get(words1.size()-1)) ) {
		System.out.println("Алгоритмы показали одинаковый результат");
    	return words;
    }
	if(Integer.parseInt(words.get(words.size()-1))<Integer.parseInt(words1.get(words1.size()-1))) {
		System.out.println("Алгоритм максимального соответствия дал меньше неизвестных слов");
		return words;
	}else {
		System.out.println("Обратный алгоритм максимального соответствия дал меньше неизвестных слов");
		return words1;

	}
	
}

}
