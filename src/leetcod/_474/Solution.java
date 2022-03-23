package leetcod._474;

public class Solution {
	public static void main(String[] args) {
		String[] strs = new String[] {"10", "0001", "111001", "1", "0"};
		int m=5;
		int n=3;
		System.out.println(findMaxForm(strs, m, n));
//		System.out.println(findMaxForm2(strs, m, n));
	}
	/**
	 * ÿ���ַ����ļ�ֵ���� 1���Դ𰸵Ĺ��׶��� 1����ѡ��ĳɱ��Ǹ��ַ����� 1 �������� 0 ��������
		�������� 1 ������������ mm��0 ������������ nn �������£�����ֵ�Ƕ���
	 * @param strs
	 * @param m
	 * @param n
	 * @return
	 */
	public static int findMaxForm(String[] strs, int m, int n) {
		//m��n�Ǳ���������ά�ȡ�0��������1����������Ʒ������ά�ȣ�
		int zeroNum;
		int oneNum;
		int[][] dp = new int[m+1][n+1];//dp[i][j]�ĺ����Ǻ���i��0��j��1��strs������Ӽ�������
		
		for(String string:strs) {
			
			zeroNum = 0;
			oneNum = 0;
			
			for(char c:string.toCharArray()) {
				if(c == '0')zeroNum++;
				else oneNum++;
			}
			
			//�˴�Ƕ����ѭ����������Ϊ��Ҫ���λ�ȡÿ���ַ���0��1�������������oneNum��zeroNum�������飨������weight���飬����Բ���Ƕ����ѭ�����У�
			for(int i=m;i>=zeroNum;i--) {
				for(int j=n;j>=oneNum;j--) {
					dp[i][j] = Math.max(dp[i][j], dp[i-zeroNum][j-oneNum]+1);//��һ��
				}
			}
			
		}
		
		return dp[m][n];
		
	}
	
//	public static int findMaxForm2(String[] strs, int m, int n) {
//			int len = strs.length;
//			int[][] zeroAndOnes = new int[len][2];
//			//�ռ��ɱ���Ϣ����ÿ���ַ�����0��1��������
//			for(int i=0;i<len;i++) {
//				String string = strs[i];
//				int zeroNum=0;
//				int oneNum=0;
//				for (char c : string.toCharArray()) {
//					if(c == '0')zeroNum++;
//					if(c == '1')oneNum++;
//				}
//				zeroAndOnes[i][0]=zeroNum;
//				zeroAndOnes[i][1]=oneNum;
//			}
//			
//			//��ʼdp�岿��
//			/* 
//			 * 1.dp[i][j]�ĺ��壺
//			 * 		һ��str����һ����Ʒ����str�ĳɱ����������ֱ�Ϊ����ַ�����������1��������0��������dp[i][j]����i��0��j��1ʱ�����������ɵ�����ֵ��
//			 * 2. ���ƹ�ʽ��
//			 * 		һ��str����һ����Ʒ������һ��str�ļ�ֵ��ֻ��1����Ϊ��ʾ����һ�����ĸ�str�ļ��ϣ���ֵֻ���ģ�������Ϊһ��str�ļ�ֵΪ1��
//			 * 		�ɵõ��ƹ�ʽ(������ѹ���ռ��)��
//			 * 		dp[i][j] = Math.max(dp[i][j],dp[i-zeroAndOnes[i][0]][j-zeroAndOnes[i][1]]+1);
//			 * 3. dp�ĳ�ʼ����
//			 * 		dp[0][0] = 0;����
//			 */
//			
//			int[][] dp = new int[m+1][n+1];
//			for(int i=m;i>=zeroAndOnes[i-1][0];i--) {
//				for(int j=n;j>=zeroAndOnes[i-1][1];j--) {
//					dp[i][j] = Math.max(dp[i][j],dp[i-zeroAndOnes[i-1][0]][j-zeroAndOnes[i-1][1]]+1);
//				}
//			}
//			
//			for (int[] is : dp) {
//				for (int is2 : is) {
//					System.out.print(is2+"\t");
//				}
//				System.out.println();
//			}
//			
//			return dp[m][n];
//	}
}
