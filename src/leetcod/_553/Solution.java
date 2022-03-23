package leetcod._553;

public class Solution {
	public static void main(String[] args) {
		int[] nums1 = new int[] {1000,100,10,2,8};
		System.out.println(OptimalDivision(nums1));
	}
	//������Ŀ��Ҫ�õ���̬�滮��
	//���ǿ����ۣ�ֻҪ�ӵڶ�λ��ʼ���������������Ϳ����ˡ�����
	public static String OptimalDivision(int[] nums) {
		int len = nums.length;
		if (len==1) {
			return String.valueOf(nums[0]);
		}
		StringBuffer res = new StringBuffer();
		for(int i=0;i<len;i++) {
			if(i==1) {
				res.append("(");
			}
			res.append(nums[i]);
			if(i==len-1)res.append(")");
			if(i!=len-1) {
				res.append("/");
			}
		}
		return res.toString();
	}
}
