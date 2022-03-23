package com.wong._2006;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	/**
	 * 解法一、暴力递归法，直接使用两个循环
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int countKDifference(int[] nums,int k) {
		int count = 0;
		for(int i=0;i<nums.length;i++) {
			for(int j=(i==nums.length-1?i:i+1);j<nums.length;j++) {
				System.out.println(nums[i]+" - "+nums[j] + " = " + Math.abs(nums[i]-nums[j]));
				if(k == Math.abs(nums[i]-nums[j])) count+=1;
			}
		}
		
		return count;
	}
	
	/**
	 * 解法二，使用哈希表，只遍历一次，然后使用哈希表来记录，满足条件的就将其记录到哈希表中。
	 * 
	 */
	public static int countKDifference2(int[] nums,int k) {
		Map<Integer, Integer> cnt = new HashMap<Integer, Integer>()	;
		int result = 0;
		for(int i=0;i<nums.length;i++) {
			result += cnt.getOrDefault(nums[i]+k, 0);
			result += cnt.getOrDefault(nums[i]-k, 0);
			cnt.put(nums[i], cnt.getOrDefault(nums[i], 0)+1);
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums1 = new int[]{1,2,2,1};
		int[] nums2 = new int[] {1,3};
		int[] nums3 = new int[] {3,2,1,5,4};
		int result = countKDifference(nums3, 2);
		System.out.println(result);
	}
}
