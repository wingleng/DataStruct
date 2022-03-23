package leetcod._1049;

public class Solution {
	public static void main(String[] args) {
		int[] stones = new int[] {2,7,4,1,8,1};
		Solution t = new Solution();
		int rst = t.lastStoneWeightII(stones);
		System.out.println(rst);
	}
	public int lastStoneWeightII(int[] stones) {
        //��Ȼ�ܹ�ת��Ϊ��������
		//������������󻯣�������Ϊ������ʯͷ�Ĳ�ֵ��
		//Ȼ�����������ʯͷ����С��ֵ
		//��ʵ���ǽ�һ��ʯͷ�Ž�һ������Ϊsum/2�ı����У������ܹ��Ž�������ʯͷ������MaxWeight��
		//���ս�����ǽ�sum-2*MaxWeight
		int n = stones.length;
		int sum = 0;
		for(int stone:stones) {
			sum+=stone;
		}
		int half = sum>>1;
		int[][] dp = new int[n+1][half+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=half;j++) {
				int curGood = stones[i-1];
				if(curGood >j) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(curGood+dp[i-1][j-curGood], dp[i-1][j]);
				}
			}
		}
		return sum - (dp[n][half] << 1);
    }
}
