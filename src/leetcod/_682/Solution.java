package leetcod._682;

import java.util.LinkedList;

public class Solution {
	public static void main(String[] args) {
		String[] ops = new String[] {"5","2","C","D","+"};
		System.out.println(getScores(ops));
	}
	public static int getScores(String[] strs) {
		LinkedList<String> scoresIntegers = new LinkedList<>();
		for (String string : strs) {
			if(string.equals("D")) {
				Integer cur = Integer.valueOf(scoresIntegers.getLast()) * 2;
				scoresIntegers.add(String.valueOf(cur));
			}else if (string.equals("+")) {
				Integer c1 = Integer.valueOf(scoresIntegers.getLast());
				Integer c2 = Integer.valueOf(scoresIntegers.get(scoresIntegers.size()-2));
				scoresIntegers.add(String.valueOf(c1+c2));
			}else if(string.equals("C")) {
				scoresIntegers.remove(scoresIntegers.size()-1);
			}else {
				scoresIntegers.add(string);
			}
		}
		
		//计算数组总和：
		int sum = 0;
		for (String string : scoresIntegers) {
			Integer cur = Integer.valueOf(string);
			sum+=cur;
		}
		return sum;
	}
}
