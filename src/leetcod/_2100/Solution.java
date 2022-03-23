package leetcod._2100;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		int[] security = new int[] {5,3,3,3,5,6,2};
		int time = 2;
		Solution tSolution = new Solution();
		List<Integer> rst = tSolution.goodDaysToRobBank(security, time);
		System.out.println(rst);
	}
	public List<Integer> goodDaysToRobBank(int[] security, int time){
		//动态规划题目
		//dp[i]，表示第i天的符合条件的天数
		//有两个，left[i]表示i前面非递增的天数有多少天；right[i]表示i后面非递减的天数有多少天。
		//递推公式，		
	}
}
