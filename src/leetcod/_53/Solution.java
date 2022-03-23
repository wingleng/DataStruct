package leetcod._53;
/*
 * �����������
 */
public class Solution {
	public static void main(String[] args) {
		int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};//���Ϊ6
		System.out.println(maxSubArray(nums));
	}
	public static int maxSubArray(int[] nums) {
		//dp[i]��ʾi֮ǰ��������������к͡�
		//���ƹ�ʽ��dp[i] =Math.max(nums[i-1]+dp[i],dp[i])��
		//i0,-2
		//i1,1
		//i2,1
		//i3,5
		//i4,5
		int[] dp = new int[nums.length];
		
		dp[0] = nums[0];
		int result = dp[0];
		for(int i=1;i<nums.length;i++) {
			dp[i] = Math.max(nums[i]+dp[i-1], nums[i]);
			if(dp[i]>result)result = dp[i];
		}
		
		return result;
	}
}
