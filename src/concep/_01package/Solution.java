package concep._01package;

public class Solution {
	public static void main(String[] args) {
		 int[] weight = new int[] {1, 3, 4};
		 int[] value = new int[] {15, 20, 30};
		 int bagWeight = 4;
	}
	public static int maxValuePackage(int[] values,int[] weights,int pag_weight) {
		//1. dp[i][j]的意思是，在容量为j的背包中，背包中所拥有的最大价值。i表示取0~i个物品
		//2. 递推关系：dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weights[i]]+values[i]);
		//该递推关系的意义是：
		//		物品只有两种状态，放，不放。当背包容量j够的时候，就将物品放进去。背包的容量j不够的时候，就不放当前物品，保持上一个状态。
		/**
		 * 背包容量够：dp[i-1][j-weights[i]]，即背包容量j-weight[i]之后剩下的容量刚好能够放进物品i
		 * 至于为什么是dp[i-1]，到上一个物品中查找，貌似是因为当前i层的状态貌似被覆盖了，会有问题。
		 */
		return 0;
	}
}
