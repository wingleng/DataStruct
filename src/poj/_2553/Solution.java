package poj._2553;
/**
 * �������������
 * ��̬�滮��Ŀ
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
		int longest = 1;//����������еĳ��ȡ�
		
		//dp[i]����˼��num[i]��ǰ���ܹ���ɵ�����������еĳ��ȡ�
		int[] dp = new int[len];
		//dp�����һ����ʼ��Ϊ1����ʾnums��һ��Ԫ�ص���������������䱾��
		//���ƹ�ϵ����num[i]��num[0]~num[i-1]���ʱ��dp[i] = dp[����num���±�]+1
		//dp����ȫ����ʼ��Ϊ1
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
