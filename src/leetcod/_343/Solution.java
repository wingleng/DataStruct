package leetcod._343;

/**
 * 整数拆分
 * @author WONG
 *
 */
public class Solution {
	public static void main(String[] args) {
		System.out.println(integerBreak(10));
	}
	public static int integerBreak(int n) {
		//要求将n按照加法的方式进行拆分，然后获取到它们最大的乘积
		//动态规划的题目
		//1，dp[i]的含义：dp[i]是拆分i所获得的最大乘积，如dp[2] = 1
		//2，递推公式：
		//		首先dp[i]的获取。j*(i-j) 以及 j*dp[i-j]，j从1开始遍历。
		//		取这两个式子中值最大的一条
		//3，递推数组的初识化，从dp[2]=1开始进行初始化，dp[0]和dp[1]没有意义
		//4，遍历顺序？
		
		int[] dp = new int[n+1];
		dp[2] = 1;
		for(int i=3;i<=n;i++) {
			for(int j=1;j<i-1;j++) {
				dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
			}
		}
		return dp[n];
	}
}
