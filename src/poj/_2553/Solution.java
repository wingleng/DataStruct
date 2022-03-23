package poj._2553;
/**
 * 求最长递增子序列
 * 动态规划题目
 * @author WONG
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution t = new Solution();
		int[] nums = new int[] {10, 9, 2, 5, 3, 7, 101, 18};
		int result = t.LIS(nums.length,nums);
		System.out.println(result);
	}
	public int LIS(int len,int[] nums) {
		int longest = 1;//最长递增子序列的长度。
		
		//dp[i]的意思是num[i]的前面能够组成的最长递增子序列的长度。
		int[] dp = new int[len];
		//dp数组第一个初始化为1，表示nums第一个元素的最长递增子序列是其本身
		//递推关系：当num[i]比num[0]~num[i-1]大的时候，dp[i] = dp[最大的num的下标]+1
		//dp数组全部初始化为1
		for(int i=0;i<dp.length;i++	) {
			dp[i] = 1;
		}
		
		
		
		for(int i=1;i<len;i++) {
			for(int j=0;j<i;j++) {
				if(nums[j]<nums[i]) {
					dp[i] = dp[j]+1;
				}
			}
			longest = Math.max(longest, dp[i]);
		}
		
		return longest;
	}
}
