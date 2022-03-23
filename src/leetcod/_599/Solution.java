package leetcod._599;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





public class Solution {
	public static void main(String[] args) {
		String[] list1 = new String[] {
				"Shogun", "Tapioca Express", "Burger King", "KFC"
		};
		String[] list2 = new String[] {
			"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"
		};
		Solution t = new Solution();
		String[] rst= t.findRestaurant(list1, list2);
		for (String string : rst) {
			System.out.println(string);
		}
	}
//	public String[] findRestaurant(String[] list1, String[] list2) {
//        List<String> result = new ArrayList<>();
//        for(int i=0,j=list2.length-1;i<list1.length && j>=0;i++,j--) {
//        	if(list1[i].equals(list2[j]))
//        		result.add(list1[i]);
//        }
//        String[] result2 = new String[result.size()];
//        result2 = result.toArray(result2);
//        return result2;
//    }
	//Ê¹ÓÃ¹þÏ£±í
	public String[] findRestaurant(String[] list1, String[] list2) {
		Map<String, Integer> record1 = new HashMap<>();
		
		for(int i=0;i<list1.length;i++) {
			record1.put(list1[i],i);
		}
		int index = Integer.MAX_VALUE;
		List<String> ret = new ArrayList<>();
		for(int i=0;i<list2.length;i++) {
			if(record1.containsKey(list2[i])) {
				int j=record1.get(list2[i]);
				if(i+j<index) {
					ret.clear();
					ret.add(list2[i]);
					index = i+j;
				}else if(i+j==index) {
					ret.add(list2[i]);
				}
			}
		}
		
		return ret.toArray(new String[ret.size()]);
		
    }
}
