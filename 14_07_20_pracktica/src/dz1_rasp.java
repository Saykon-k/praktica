import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class dz1_rasp {

	public static void main(String[] args) {
	    Map<String , ArrayList> some = states(3,3);
	    for (Map.Entry entry : some.entrySet()) {
	        System.out.println("Key: " + entry.getKey() + " Value: "
	            + entry.getValue());
	    }
	    Map<String,String> match = new  HashMap<String,String>(); 
	    match.put("m1", "w2");
	    match.put("m2", "w1");
	    check(some,match);
	}
	//генерация изначальных данных 
	public static Map<String, ArrayList> states(int man,int woman){
		Map<String, ArrayList> states = new HashMap<String, ArrayList>();
		
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
	
	public static ArrayList<String> check( Map<String , ArrayList> allcand , Map<String,String> match){
		 ArrayList<String> block = new ArrayList<String>();
		 for(String man : match.keySet()) {
			// System.out.println(allcand.get(man).indexOf(match.get(man)));
			 for(String woman : match.values()) {
			  if(allcand.get(man).indexOf(woman)>allcand.get(man).indexOf(man) && allcand.get(woman).indexOf(man)>allcand.get(woman).indexOf(match.) ){
				  System.out.println(allcand.get(man).indexOf(woman)+" "+allcand.get(man).indexOf(match.get(man)));
			  }
			 }
		 }
		 
		 return block;
	}
}
