package leetcod._96;

public class Solution {
	public static void main(String[] args) {
		System.out.println(SBT(3));
	}
	public static int SBT(int n) {
		int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
	}
}
