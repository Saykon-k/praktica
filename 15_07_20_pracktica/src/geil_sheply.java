import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.omg.PortableServer.POAManagerPackage.State;

public class geil_sheply {
	public static void main(String args[]) {
		int m = 4;
		int w = 4;
		HashMap<String , ArrayList<String>> some =states( m,w);
	    ArrayList<String> r = new ArrayList<String>();
	    //большой тест
	    Map<String,String> match = new  HashMap<String,String>(); 
	    some.clear();
	    String s [] = {"w3", "w1", "w5", "w7", "w4", "w2", "w8", "w6"};
	    for(String s1 : s) r.add(s1);
	    some.put("m1", (ArrayList<String>) r.clone());
	    r.clear();
	    String q [] = {"w6", "w1", "w3", "w4", "w8", "w7", "w5", "w2"};
	    for(String s1 : q) r.add(s1);
	    some.put("m2", (ArrayList<String>) r.clone());
	    r.clear();
	    String q1 [] = {"w7", "w4", "w3", "w6", "w5", "w1", "w2", "w8"};
	    for(String s1 : q1) r.add(s1);
	    some.put("m3", (ArrayList<String>) r.clone());
	    r.clear();
	    String q2 [] = {"w5", "w3", "w8", "w2", "w6", "w1", "w4", "w7"};
	    for(String s1 : q2) r.add(s1);
	    some.put("m4", (ArrayList<String>) r.clone());
	    r.clear();
	    String q3 [] = {"w4", "w1", "w2", "w8", "w7", "w3", "w6", "w5"};
	    for(String s1 : q3) r.add(s1);
	    some.put("m5", (ArrayList<String>) r.clone());
	    r.clear();
	    String q4 [] = {"w6", "w2", "w5", "w7", "w8", "w4", "w3", "w1"};
	    for(String s1 : q4) r.add(s1);
	    some.put("m6", (ArrayList<String>) r.clone());
	    r.clear();
	    String q5 [] = {"w7", "w8", "w1", "w6", "w2", "w3", "w4", "w5"};
	    for(String s1 : q5) r.add(s1);
	    some.put("m7", (ArrayList<String>) r.clone());
	    r.clear();	    
	    String q6 [] = {"w2", "w6", "w7", "w1", "w8", "w3", "w4", "w5"};
	    for(String s1 : q6) r.add(s1);
	    some.put("m8", (ArrayList<String>) r.clone());
	    r.clear();
	    
	    String q7 [] = {"m4", "m3", "m8", "m1", "m2", "m5", "m7", "m6"};
	    for(String s1 : q7) r.add(s1);
	    some.put("w1", (ArrayList<String>) r.clone());
	    r.clear();
	    String q8 [] = {"m3", "m7", "m5", "m8", "m6", "m4", "m1", "m2"};
	    for(String s1 : q8) r.add(s1);
	    some.put("w2", (ArrayList<String>) r.clone());
	    r.clear();
	    String q9 [] = {"m7", "m5", "m8", "m3", "m6", "m2", "m1", "m4"};
	    for(String s1 : q9) r.add(s1);
	    some.put("w3", (ArrayList<String>) r.clone());
	    r.clear();
	    String q10 [] = {"m6", "m4", "m2", "m7", "m3", "m1", "m5", "m8"};
	    for(String s1 : q10) r.add(s1);
	    some.put("w4", (ArrayList<String>) r.clone());
	    r.clear();
	    String q11 [] = {"m8", "m7", "m1", "m5", "m6", "m4", "m3", "m2"};
	    for(String s1 : q11) r.add(s1);
	    some.put("w5", (ArrayList<String>) r.clone());
	    r.clear();
	    String q12 [] = {"m5", "m4", "m7", "m6", "m2", "m8", "m3", "m1"};
	    for(String s1 : q12) r.add(s1);
	    some.put("w6", (ArrayList<String>) r.clone());
	    r.clear();
	    String q13 [] = {"m1", "m4", "m5", "m6", "m2", "m8", "m3", "m7"};
	    for(String s1 : q13) r.add(s1);
	    some.put("w7", (ArrayList<String>) r.clone());
	    r.clear();
	    String q14 [] = {"m2", "m5", "m4", "m3", "m7", "m8", "m1", "m6"};
	    for(String s1 : q14) r.add(s1);
	    some.put("w8", (ArrayList<String>) r.clone());
	    r.clear();
//	    match.put("m1", "w1");
//	    match.put("m2", "w2");
//	    match.put("m3", "w3");
//	    match.put("m4", "w4");

//
	    System.out.println("Изначальное состояние");
	    for (Map.Entry entry : some.entrySet()) {
	        System.out.println("Key: " + entry.getKey() + " Value: "
	            + entry.getValue());
	    }
	    
	    shep_meth(some,8,8,1);
	}
		
	// сложная функция основная
	public static ArrayList<String> shep_meth(HashMap<String , ArrayList<String>> allpriority,int sizem,int sizew,int len){
		HashMap<String, ArrayList<String>> states = new HashMap<String, ArrayList<String>>();
		ArrayList<String> raspr = new ArrayList<String >();
		ArrayList<String> nexttry = new ArrayList<String >();
		//находим первые места 
		//как-то делить в соотношении
		//самый первый шаг.. 
		int kM = 1;
		//проверяем размер states если размер идентичен количеству индивидов w, то нет конкруренции между теми. кто предлагает
		int col_w  = 0;
		int sh = 0;
		System.out.println();
		while(col_w != sizew) {
			kM =1;
			for(String s : allpriority.keySet()) {
				if(s.contains("m")) {
				if(kM>sizem) {
					break;
				}
				kM++;
				String firstpalce = allpriority.get(s).get(0);
				ArrayList<String> checkplace = allpriority.get(firstpalce);
				int findplace = checkplace.indexOf(s);
				if(states.containsKey(firstpalce)) {
					states.get(firstpalce).add(s+" "+findplace);
				}else {
					ArrayList<String > prom = new ArrayList<String>(); 
					prom.add(s+" "+findplace);
					states.put(firstpalce,(ArrayList<String>) prom.clone());
					prom.clear();
				}
			}
			}
			System.out.println("проверяются повторы");
			for (Map.Entry entry : states.entrySet()) 
		        System.out.println("Key: " + entry.getKey() + " Value: "+ entry.getValue());
			System.out.println();
			prioriti(states, allpriority,nexttry,sizem);
			
			System.out.println("текущее значение после проверки на повторы");
			for (Map.Entry entry : allpriority.entrySet()) 
			     System.out.println("Key: " + entry.getKey() + " Value: "+ entry.getValue());
			System.out.println();
			col_w = states.size();
			states.clear();

		}
		System.out.println("финальные значения");
		for (Map.Entry entry : allpriority.entrySet()) 
		     System.out.println("Key: " + entry.getKey() + " Value: "+ entry.getValue());
		System.out.println();
		System.out.println("последний повтор является ответом");
	
		return raspr;
	}
	//public static findmaxretnexttry()
	public static void prioriti(
			HashMap<String, ArrayList<String>> states,HashMap<String , ArrayList<String>> allpriority,ArrayList <String> nexttry,int msize ){
		int max = 1000000;  
		String prommax = "";
		ArrayList<String> remel = new ArrayList<String>();
		for(ArrayList<String> s : states.values()) {
			for(String s1 : s ) {
				String prom[] = s1.split(" ");
				//находим минимальный в списке предпочтений w
				if(Integer.parseInt(prom[1])<max) {
					max = Integer.parseInt(prom[1]);
					prommax = s1;
				}
			}
			//добавляем список тех, кто будет в следующий раз учавствовать
			for(String s1 : s) {
				String prom[] = s1.split(" ");
				if(Integer.parseInt(prom[1]) != max) {
					remel.add(s1);
				}
			}
	
			//удаляем элементы в списке предпочтений
			for(String s2 : remel) {
				
				s.remove(s.indexOf(s2));
			}
			//обнуляем переменные 
			max =100000;
			prommax = "";
			remel.clear();
		}
		boolean check = false;

	    removem(states,allpriority,msize);


		//удаляеются последующие элементы из списка предпочтений у wi 
		ArrayList<String> del = new ArrayList<String>();
		for(String s : states.keySet()) {
			for(String s1 : allpriority.get(s)) {
				
				if(s1.equals(states.get(s).get(0).split(" ")[0])) {
					check = true;
					}else {
						if( check) {
							del.add(s1);
						}
					}
			}
			//удаляем эти элменты
			for(String s2 : del) {
				 allpriority.get(s).remove( allpriority.get(s).indexOf(s2));
			}
			del.clear();
			check = false;
		}


	}
	public static void removem (HashMap<String, ArrayList<String>> states,HashMap<String , ArrayList<String>> allpriority,int sizem) {
		boolean check = false;
		ArrayList<String> del = new ArrayList<String>();
		for(Entry<String, ArrayList<String>> s : states.entrySet()) {
			String current = s.getValue().get(0).split(" ")[0];
			for (String s1 :allpriority.get(s.getKey())) {
				if(s1.equals(current)) {
					check = true;
				}else {
					if(check) {
						del.add(s1);
					}
				}
				}
				for(String s2 : del) {
					if (allpriority.get(s2).indexOf(s.getKey()) == -1) {
					}else {
						allpriority.get(s2).remove(allpriority.get(s2).indexOf(s.getKey()));

					}
				}
			del.clear();
			check = false;
			}
		
		
	}
	public static HashMap<String,ArrayList<String>> states(int man,int woman){
		HashMap<String, ArrayList<String>> states = new HashMap<String, ArrayList<String>>();
		
		for(int i = 0 ; i<man;i++) { states.put("m"+Integer.toString(i+1),retList(woman,"w"));}
		
		for(int i = 0 ; i<woman;i++) { states.put("w"+Integer.toString(i+1),retList(man,"m"));}
		
		return states;
	}
	public static ArrayList<String> retList(int n,String s) {
	    Random rand = new Random();
	    ArrayList<String> givenList = new ArrayList<String>();
	    for(int i = 1; i <= n; i++) givenList.add(s+Integer.toString(i));
	    
	    int numberOfElements = n;
	    
	    ArrayList<String> returned = new ArrayList<String>();
	    for (int i = 0; i < numberOfElements; i++) {
	        int randomIndex = rand.nextInt(givenList.size());
	        returned.add(givenList.get(randomIndex));
	        givenList.remove(randomIndex);
	    }
	    return returned;
	}
	
	public static ArrayList<String[]> blockpar(HashMap<String , ArrayList<String>> allpriority,  Map<String,String> match ){
		ArrayList<String[]> block = new ArrayList<String[] >();
		for(String m : match.keySet()) {
			//достаем местоположение в данном распределении и сравниваем с другими 
			int state =  allpriority.get(m).indexOf(match.get(m));

			ArrayList<String> members = allpriority.get(m);//чтобы постоянно не обращаться
			//очень плохая строчка,так как здесь генерируется список ,Но это вынужденная работа,так как невозможно достать ТОТ ключ из множества 
			for(Map.Entry w : match.entrySet()) {
				//так как значение может быть -1, то обязтельная проверка на наличие элемента в списке
				if(members.indexOf(w.getValue()) < state  && members.indexOf(w.getValue())>-1) {
					//здесь говорится 
					//достанем значение из списка два( не ключ) 
					//сформируем его список предпочтений и найдем в нем кандидата остальные две проверки написаны по соображениям выше 
					if(allpriority.get(
							w.getValue()).indexOf(m)<allpriority.get(w.getValue()).indexOf(w.getKey()) 
							&& allpriority.get(w.getValue()).indexOf(m)>-1 
							&& allpriority.get(w.getValue()).indexOf(w.getKey())>-1) {
						//здесь пара  1 2 более предпочтительная,чем 1-3  
						//System.out.println(m+" "+ w.getValue()+" "+allpriority.get(m).get(state) );
						String s[]= { m, (String) w.getValue()};
						block.add(s);
					}
					
				}
			}
	}
		return block;
}
	public static  Map<String,String> breakpar( Map<String,String> match,String pair[]){
		 Map<String,String> par = new  HashMap<String,String>() ;
		 String s = match.get(pair[0]);
		 String s1 = "";
		for(Map.Entry w : match.entrySet()) {
			if(w.getValue().equals(pair[1])) {
				s1 = (String)w.getKey();
				//match.remove(w.getKey());
			}
		}
		 match.remove(s1);
		 match.remove(pair[0]);
		 match.put(pair[0], pair[1]);
		 match.put(s1, s);
		 par = match;
		return par;
	}
	
	public static Map<String,String>  goodstate(HashMap<String , ArrayList<String>> allpriority,  Map<String,String> match ){
					Map<String,String> goodst = match;
					ArrayList<String[]> check = new ArrayList<String[]>();
					check = blockpar(allpriority,goodst);
					while(!check.isEmpty()) {
						//System.out.println(goodst.toString());
						System.out.println(check.get(0)[0] + " " + check.get(0)[1]);

						goodst = breakpar(goodst,check.get(0));
						check = blockpar(allpriority,goodst);
					}
				return goodst;

		
	}
}
