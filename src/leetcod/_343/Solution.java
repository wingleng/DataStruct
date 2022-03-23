package leetcod._343;

/**
 * �������
 * @author WONG
 *
 */
public class Solution {
	public static void main(String[] args) {
		System.out.println(integerBreak(10));
	}
	public static int integerBreak(int n) {
		//Ҫ��n���ռӷ��ķ�ʽ���в�֣�Ȼ���ȡ���������ĳ˻�
		//��̬�滮����Ŀ
		//1��dp[i]�ĺ��壺dp[i]�ǲ��i����õ����˻�����dp[2] = 1
		//2�����ƹ�ʽ��
		//		����dp[i]�Ļ�ȡ��j*(i-j) �Լ� j*dp[i-j]��j��1��ʼ������
		//		ȡ������ʽ����ֵ����һ��
		//3����������ĳ�ʶ������dp[2]=1��ʼ���г�ʼ����dp[0]��dp[1]û������
		//4������˳��
		
		int[] dp = new int[n+1];
		dp[2] = 1;
		for(int i=3;i<=n;i++) {
			for(int j=1;j<i-1;j++) {
				dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
			}
		}
		return dp[n];
	}
}
