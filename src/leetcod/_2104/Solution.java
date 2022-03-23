package leetcod._2104;

public class Solution {
	public static void main(String[] args) {
		int[] nums = new int[] {4,-2,-3,4,1};
		Solution tSolution = new Solution();
		tSolution.subArrayRanges(nums);
	}
	public long subArrayRanges(int[] nums) {
		int sublen = 1;//子数组的初始长度
		int i = 0;//数组的指针
		int len = nums.length;
		long sum = 0;
		
		while(sublen<len+1) {
			int end = i+sublen-1;//子数组的末尾位置，i为数组开始的位置
			
			//处理子数组：本题要求，求子数组中最大的值-最小值的差，并且保存起来
//			System.out.println("当前子数组的开始位置和结束位置"+nums[i]+"==>"+nums[(i+sublen-1)]);
			//遍历子数组，寻找最大和最小值
			int max= Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			System.out.println("当前的子数组:");
			for(int j=i;j<=end;j++) {
				System.out.print(nums[j]);
				max= max>nums[j]?max:nums[j];
				min= min<nums[j]?min:nums[j];
			}
			//计算子数组max-min的差值
			sum += max - min;
			System.out.println("\nmin:"+min+"max:"+max);
		
			
			i++;
			if(end==len-1) {
				sublen++;
				i=0;
			}
		
		}
		
		System.out.println("总和:"+sum);
		return 0;
	}
}
