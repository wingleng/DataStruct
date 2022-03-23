package leetcod._746;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * ������С��������¥��
 * @author WONG
 *
 */
public class Solution {
	public static void main(String[] args) {
		int result = minCostClimbingStair(new int[] {10,15,20});
		System.out.println(result);
	}
	public static int minCostClimbingStair(int[] cost) {
		int[] dp = new int[cost.length];
		dp[0] = cost[0];
		dp[1] = cost[1];
		for(int i=2;i<cost.length;i++) {
			dp[i]=Math.min(dp[i-1], dp[i-2])+cost[i];
		}
		//���һ���������Ϊ���û���
		return Math.min(dp[cost.length-1], dp[cost.length-2]);
	}
}
