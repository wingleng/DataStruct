package leetcod._2100;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		int[] security = new int[] {5,3,3,3,5,6,2};
		int time = 2;
		Solution tSolution = new Solution();
		List<Integer> rst = tSolution.goodDaysToRobBank(security, time);
		System.out.println(rst);
	}
	public List<Integer> goodDaysToRobBank(int[] security, int time){
		//��̬�滮��Ŀ
		//dp[i]����ʾ��i��ķ�������������
		//��������left[i]��ʾiǰ��ǵ����������ж����죻right[i]��ʾi����ǵݼ��������ж����졣
		//���ƹ�ʽ��		
	}
}
