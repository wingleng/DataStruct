package _2016;

public class Solution {
	 public static void main(String[] args) {
		int[] nums1 = new int[]{7,1,5,4};
		int[] nums2 = new int[] {9,4,3,2};
		int[] nums3 = new int[] {1,5,2,10};
//		int res1 = maximumDifference(nums1);
//		int res2 = maximumDifference(nums2);
//		int res3 = maximumDifference(nums3);
//		System.out.println("nums1 =  "+res1);
//		System.out.println("nums2 =  "+res2);
//		System.out.println("nums3 =  "+res3);
		maximumDifference2(nums1);
	}
	 public static int maximumDifference(int[] nums) {
		 //����ĿҪ��ľ���������ѡȡ��������һ��һ�ң�Ҫ����ߵ���i����С���ұߵ���j��Ȼ�������������������ֵ
		 //ʹ����ɵ�ı���������һ��һ���Գ���
		 int rst = -1;
		 for(int i=0;i<=nums.length-2;i++) {
			 for(int j=i+1;j<=nums.length-1;j++) {
				 if(nums[i]<nums[j]) {
					 int cur_result = nums[j]-nums[i];
					 if(cur_result>rst)rst = cur_result;
				 }
			 }
		 }
		 return rst;
	 }
	 
	 //�ⷨ����ά��һ��ǰ׺��Сֵ
	 public static int maximumDifference2(int[] nums) {
	        int n = nums.length;
	        int ans = -1, premin = nums[0];
	        for (int i = 1; i < n; ++i) {
	            if (nums[i] > premin) {
	                ans = Math.max(ans, nums[i] - premin);
	            } else {
	                premin = nums[i];
	            }
	        }
	        return ans;
	    }

}
