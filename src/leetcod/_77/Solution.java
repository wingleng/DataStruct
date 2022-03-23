package leetcod._77;

import java.util.*;

public class Solution {
	static List<List<Integer>> result = new ArrayList<>();
	static LinkedList<Integer> path = new LinkedList<>();
	
	public static void main(String[] args) {
		List<List<Integer>> rstList = combination(1, 1);
		rstList.iterator();
		for (List<Integer> list : rstList) {
			System.out.println(list.get(0));
		}
	}
	
	public static List<List<Integer>> combination(int n,int k){
		trackback(n, k, 1);
		return result;
	}
	public static void trackback(int n,int k,int startindex) {
		if(path.size()==k) {
			result.add(new ArrayList<>(path));//¼ÇÂ¼½á¹û
			return;
		}
		for(int i=startindex;i<=n;i++) {
			path.add(i);
			trackback(n, k, i+1);
			path.removeLast();
		}
	}
}