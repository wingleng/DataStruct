package leetcod._1049;

public class Solution {
	public static void main(String[] args) {
		int[] stones = new int[] {2,7,4,1,8,1};
		Solution t = new Solution();
		int rst = t.lastStoneWeightII(stones);
		System.out.println(rst);
	}
	public int lastStoneWeightII(int[] stones) {
        //居然能够转化为背包问题
		//该问题可以扩大化，将其视为求两堆石头的差值。
		//然后就是求两堆石头的最小差值
		//其实就是将一堆石头放进一个容量为sum/2的背包中，求其能够放进的最大的石头的重量MaxWeight。
		//最终结果就是将sum-2*MaxWeight
		int n = stones.length;
		int sum = 0;
		for(int stone:stones) {
			sum+=stone;
		}
		int half = sum>>1;
		int[][] dp = new int[n+1][half+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=half;j++) {
				int curGood = stones[i-1];
				if(curGood >j) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(curGood+dp[i-1][j-curGood], dp[i-1][j]);
				}
			}
		}
		return sum - (dp[n][half] << 1);
    }
}
