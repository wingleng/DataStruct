package leetcod._2104;

public class Solution {
	public static void main(String[] args) {
		int[] nums = new int[] {4,-2,-3,4,1};
		Solution tSolution = new Solution();
		tSolution.subArrayRanges(nums);
	}
	public long subArrayRanges(int[] nums) {
		int sublen = 1;//������ĳ�ʼ����
		int i = 0;//�����ָ��
		int len = nums.length;
		long sum = 0;
		
		while(sublen<len+1) {
			int end = i+sublen-1;//�������ĩβλ�ã�iΪ���鿪ʼ��λ��
			
			//���������飺����Ҫ����������������ֵ-��Сֵ�Ĳ���ұ�������
//			System.out.println("��ǰ������Ŀ�ʼλ�úͽ���λ��"+nums[i]+"==>"+nums[(i+sublen-1)]);
			//���������飬Ѱ��������Сֵ
			int max= Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			System.out.println("��ǰ��������:");
			for(int j=i;j<=end;j++) {
				System.out.print(nums[j]);
				max= max>nums[j]?max:nums[j];
				min= min<nums[j]?min:nums[j];
			}
			//����������max-min�Ĳ�ֵ
			sum += max - min;
			System.out.println("\nmin:"+min+"max:"+max);
		
			
			i++;
			if(end==len-1) {
				sublen++;
				i=0;
			}
		
		}
		
		System.out.println("�ܺ�:"+sum);
		return 0;
	}
}
