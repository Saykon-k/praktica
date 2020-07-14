import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class dz1_rasp {

	public static void main(String[] args) {
		HashMap<String , ArrayList<String>> some =states(4,4);
	    ArrayList<String> r = new ArrayList<String>();
	    Map<String,String> match = new  HashMap<String,String>(); 
	    match.put("m1","w2");
	    match.put("m2","w3");
	    match.put("m3","w1");
	    match.put("m4","w4");

	    for (Map.Entry entry : some.entrySet()) {
	        System.out.println("Key: " + entry.getKey() + " Value: "
	            + entry.getValue());
	    }
	    for (Map.Entry entry : match.entrySet()) {
	        System.out.println("Key: " + entry.getKey() + " Value: "
	            + entry.getValue());
	    }
	    blockpar(some,match);
	    goodstate(some,match);
	   
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
						System.out.println(m+" "+ w.getValue()+" "+allpriority.get(m).get(state) );
						String s[]= { m, (String) w.getValue() ,allpriority.get(m).get(state) };
						block.add(s);
					}
					
				}
			}
	}
		return block;
}
	public static Map<String,String>  goodstate(HashMap<String , ArrayList<String>> allpriority,  Map<String,String> match ){
					Map<String,String> goodst =new HashMap<String , String>();
					ArrayList<String[]> check = new ArrayList<String[]>();
					while(!check.isEmpty()) {
						check = blockpar(allpriority,match);
						if(!check.isEmpty()) {
							String rep []= check.get(0);
							match.replace(rep[0], rep[2], rep[1]);
							//match.re
						}
					}
					goodst = match;
				return goodst;

		
	}
}
