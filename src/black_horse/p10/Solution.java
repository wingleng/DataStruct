package black_horse.p10;

public class Solution {
	/**
	 * ����һ����0��1��ɵľ���1��ʾ���죬0��ʾˮ��1������������������������ʾһ�����졣
	 * ����1���жϾ����е��������
	 * ����2���жϾ��������������
	 * @param args
	 */
	public static void main(String[] args) {
		//�þ���ӵ��6������
		int[][] grid = new int[][] {
			{0,0,1,0,0,0,0,1,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,1,1,0,0,0},
			{0,1,1,0,1,0,0,0,0,0,0,0,0},
			{0,1,0,0,1,1,0,0,1,0,1,0,0},
			{0,1,0,0,1,1,0,0,1,1,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,1,0,0},
			{0,0,0,0,0,0,0,1,1,1,0,0,0},
			{0,0,0,0,0,0,0,1,1,0,0,0,0}};
//		int result = landcount(grid);
//		System.out.println(result);
		
		//��������������������������������Ҳ��6
		int result2 = landArea(grid);
		System.out.println(result2);
		

	}
	public static int landcount(int[][] nums) {
		//��������Ƶ�˼·�����Ƕ���һ��infect���̣��ù��̿��Խ����ڵ�1ȫ����Ϊ2��
		//Ȼ��ͱ����������飬����Ϊ1�ģ���ִ��infect����
		int M = nums.length;//��
		int N = nums[0].length;//��
		int res = 0;
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(nums[i][j]==1) {
					res++;
					infect(nums,i,j,M,N);
				}
			}
		}
		return res;
	}
	
	//��Ⱦ�����������ڵ�1ȫ����дΪ2
	public static void infect(int [][]nums,int i,int j,int M,int N) {
		//������ֹ��������Խ�磬��Խ�磬��С��0����С��0����ǰ����Ϊ2
		if(i<0 || i>=M || j<0 || j>=N || nums[i][j]!=1) {
			return ;
		}
		//��������ȫ����Ҫ����Ϊ2
		nums[i][j] = 2;
		infect(nums,i+1,j,M,N);
		infect(nums,i-1,j,M,N);
		infect(nums,i,j+1,M,N);
		infect(nums,i,j-1,M,N);
	}
	
	
	/*********
	 * ������Ŀ����Ҫ���ؾ����У�������ĵ���
	 * �ǲ����ڸ�Ⱦ�����У�˳�����һ��ÿ������������������
	 */
	public static int landArea = 0;
	public static int landArea(int[][] martrix) {
		int M = martrix.length;//��
		int N = martrix[0].length;//��
		int res = 0;
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(martrix[i][j]==1) {
					landArea = 0;
					infect2(martrix,i,j,M,N);
					if(landArea>res) {
						res = landArea;
					}
				}
			}
		}
		return res;
	}
	public static void infect2(int [][]nums,int i,int j,int M,int N) {
		//������ֹ��������Խ�磬��Խ�磬��С��0����С��0����ǰ����Ϊ2
		if(i<0 || i>=M || j<0 || j>=N || nums[i][j]!=1) {
			return ;
		}
		//��������ȫ����Ҫ����Ϊ2
		nums[i][j] = 2;
		landArea++;
		infect2(nums,i+1,j,M,N);
		infect2(nums,i-1,j,M,N);
		infect2(nums,i,j+1,M,N);
		infect2(nums,i,j-1,M,N);
	}
}
