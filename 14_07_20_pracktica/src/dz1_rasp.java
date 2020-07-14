import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class dz1_rasp {

	public static void main(String[] args) {
		HashMap<String , ArrayList<String>> some =states(3,3);
	    ArrayList<String> r = new ArrayList<String>();
	    Map<String,String> match = new  HashMap<String,String>(); 
	    some.clear();
	    r.add("w4");
	    r.add("w3");
	    r.add("w1");
	    r.add("w2");
	    some.put("m1", (ArrayList<String>) r.clone());
	    r.clear();
	    
	    r.add("w4");
	    r.add("w2");
	    r.add("w3");
	    r.add("w1");
	    some.put("m2", (ArrayList<String>) r.clone());
	    r.clear();
	  
	    r.add("w4");
	    r.add("w3");
	    r.add("w1");
	    r.add("w2");
	    some.put("m3", (ArrayList<String>) r.clone());
	    r.clear();
	    
	    r.add("w2");
	    r.add("w4");
	    r.add("w3");
	    r.add("w1");
	    some.put("m4", (ArrayList<String>) r.clone());
	    r.clear();
	    
	    r.add("m4");
	    r.add("m2");
	    r.add("m3");
	    r.add("m1");
	    some.put("w1", (ArrayList<String>) r.clone());
	    r.clear();
	    
	    
	    r.add("m4");
	    r.add("m3");
	    r.add("m1");
	    r.add("m2");
	    some.put("w2", (ArrayList<String>) r.clone());
	    r.clear();
	    
	    
	    r.add("m2");
	    r.add("m1");
	    r.add("m4");
	    r.add("m3");
	    some.put("w3", (ArrayList<String>) r.clone());
	    r.clear();	    
	    
	    r.add("m3");
	    r.add("m2");
	    r.add("m1");
	    r.add("m4");
	    some.put("w4", (ArrayList<String>) r.clone());
	    r.clear();
	    
	    match.put("m1", "w1");
	    match.put("m2", "w2");
	    match.put("m3", "w3");
	    match.put("m4", "w4");

//
	    for (Map.Entry entry : some.entrySet()) {
	        System.out.println("Key: " + entry.getKey() + " Value: "
	            + entry.getValue());
	    }
	    for (Map.Entry entry : match.entrySet()) {
	        System.out.println("Key: " + entry.getKey() + " Value: "
	            + entry.getValue());
	    }
	    //blockpar(some,match);
	    System.out.println(goodstate(some,match).toString());
	    //goodstate(some,match);
	}
	//генерация изначальных данных 
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
					//здесь говорится достанем значение из списка два( не ключ) сформируем его список предпочтений и найдем в нем кандидата остальные две проверки написаны по соображениям выше 
					if(allpriority.get(w.getValue()).indexOf(m)<allpriority.get(w.getValue()).indexOf(w.getKey()) && allpriority.get(w.getValue()).indexOf(m)>-1 && allpriority.get(w.getValue()).indexOf(w.getKey())>-1) {
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
