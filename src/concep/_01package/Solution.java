package concep._01package;

public class Solution {
	public static void main(String[] args) {
		 int[] weight = new int[] {1, 3, 4};
		 int[] value = new int[] {15, 20, 30};
		 int bagWeight = 4;
	}
	public static int maxValuePackage(int[] values,int[] weights,int pag_weight) {
		//1. dp[i][j]����˼�ǣ�������Ϊj�ı����У���������ӵ�е�����ֵ��i��ʾȡ0~i����Ʒ
		//2. ���ƹ�ϵ��dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weights[i]]+values[i]);
		//�õ��ƹ�ϵ�������ǣ�
		//		��Ʒֻ������״̬���ţ����š�����������j����ʱ�򣬾ͽ���Ʒ�Ž�ȥ������������j������ʱ�򣬾Ͳ��ŵ�ǰ��Ʒ��������һ��״̬��
		/**
		 * ������������dp[i-1][j-weights[i]]������������j-weight[i]֮��ʣ�µ������պ��ܹ��Ž���Ʒi
		 * ����Ϊʲô��dp[i-1]������һ����Ʒ�в��ң�ò������Ϊ��ǰi���״̬ò�Ʊ������ˣ��������⡣
		 */
		return 0;
	}
}
