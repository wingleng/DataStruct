package leetcod._122;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {7,1,5,3,6,4};
		System.out.println(maxProfit(nums));
	}
	public static int maxProfit(int[] nums) {
		int result = 0;
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i+1]-nums[i]>0) {
				result+=nums[i+1]-nums[i];
			}
		}
		return result;
	}

}
