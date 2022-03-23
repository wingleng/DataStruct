package leetcod._416;

import java.util.Arrays;
import java.util.List;

/**
 * �ָ�Ⱥ��Ӽ�
 * @author WONG
 *
 */
public class Solution {
	public static void main(String[] args) {
		int[] nums = new int[] {1,5,11,5};
		Solution t = new Solution();
//	 	System.out.println(t.canPartition2(nums)); 
		t.canPartition2(nums);
	}
	 public boolean canPartition(int[] nums) {
	        //01�������⡣
		//dp�����ʼ����˵�����sum/2���ᳬ��10000
	    int[] dp = new int[10001];
	    Arrays.fill(dp, 0);
	    
	    int sum = 0;
	    for(int j=0;j<nums.length;j++) {
	    	sum+= nums[j];
	    }
	    int target = sum/2;
	    
	    //��ʼ�������������˵��ʹ��һάdp����ʱ����Ҫ�������
	    for(int i=0;i<nums.length;i++) {
	    	for(int j=target;j>=nums[i];j--) {
	    		dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);
	    	}
	    }
	    if(dp[target] == target) {
	    	return true;
	    }
	    
	    return false;
	    }
	 
	 public boolean canPartition2(int[] nums) {
	        //�����˵�����ʾ����Ҽ����������Ƿ��ܹ���������Ϊsum/2�ı���
	        int sum =0;
	        for(int num:nums)sum+=num;
	        int half = sum/2;
	        int n=nums.length;
	        boolean dp[][] = new boolean[n+1][half+1];

	        for(int i=0;i<n+1;i++){
	            for(int j=0;j<half+1;j++){
	                if(i==0 && j==0)//��ʼ��
	                    dp[i][j] = true;
	                else if(i==0){
	                    dp[i][j] = false;
	                }
	                else if(j==0){//����Ϊʲôj=0��ʱ����Ϊtrue��
	                    dp[i][j] = true;
	                }
	                else {
	                    if(j >= nums[i-1]){
	                        dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i-1]];
	                    }else{
	                        dp[i][j] = dp[i-1][j];
	                }
	                }
	            }
	        }

	        for(boolean[] row:dp) {
	        	for(boolean sin:row) {
	        		System.out.print(sin+" ");
	        	}
	        	System.out.println();
	        }
	        return dp[n][half];
	    }
}
