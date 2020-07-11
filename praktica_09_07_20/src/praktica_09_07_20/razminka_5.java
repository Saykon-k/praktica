package praktica_09_07_20;

import java.util.ArrayList;
import java.util.Collections;

public class razminka_5 {
	public static void main(String args[]) {
		
	}
	public static ArrayList<Integer> move_cicle(ArrayList<Integer> list){
		int value_max = list.get(0) ,value_min = list.get(0);
		int max_index = 0, min_index = 0;
		for(int i = 1; i<list.size(); i++) {
			if(list.get(i)>value_max) {
				value_max = list.get(i);
				max_index = i;
			}
			if(list.get(i)<value_min) {
				value_min = list.get(i);
				min_index = i;
			}
		}
		int diff_pos = min_index-max_index;
	}

}
