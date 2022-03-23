package black_horse.p10;

public class Solution {
	/**
	 * 给定一个由0和1组成的矩阵，1表示岛屿，0表示水，1可以上下左右连接起来，表示一个岛屿。
	 * 问题1：判断矩阵中岛屿的数量
	 * 问题2：判断矩阵中最大岛屿的面积
	 * @param args
	 */
	public static void main(String[] args) {
		//该矩阵拥有6个矩阵
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
		
		//计算最大岛屿的面积，这个矩阵中最大岛屿面积也是6
		int result2 = landArea(grid);
		System.out.println(result2);
		

	}
	public static int landcount(int[][] nums) {
		//按照左程云的思路，就是定义一个infect过程，该过程可以将相邻的1全部改为2。
		//然后就遍历整个数组，遇到为1的，就执行infect过程
		int M = nums.length;//行
		int N = nums[0].length;//列
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
	
	//感染，将所有相邻的1全部改写为2
	public static void infect(int [][]nums,int i,int j,int M,int N) {
		//设置终止条件，行越界，列越界，行小于0，列小于0，当前的数为2
		if(i<0 || i>=M || j<0 || j>=N || nums[i][j]!=1) {
			return ;
		}
		//上下左右全部都要设置为2
		nums[i][j] = 2;
		infect(nums,i+1,j,M,N);
		infect(nums,i-1,j,M,N);
		infect(nums,i,j+1,M,N);
		infect(nums,i,j-1,M,N);
	}
	
	
	/*********
	 * 变种题目，需要返回矩阵中，面积最大的岛。
	 * 是不是在感染过程中，顺便计算一下每个岛屿的面积。。。。
	 */
	public static int landArea = 0;
	public static int landArea(int[][] martrix) {
		int M = martrix.length;//行
		int N = martrix[0].length;//列
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
		//设置终止条件，行越界，列越界，行小于0，列小于0，当前的数为2
		if(i<0 || i>=M || j<0 || j>=N || nums[i][j]!=1) {
			return ;
		}
		//上下左右全部都要设置为2
		nums[i][j] = 2;
		landArea++;
		infect2(nums,i+1,j,M,N);
		infect2(nums,i-1,j,M,N);
		infect2(nums,i,j+1,M,N);
		infect2(nums,i,j-1,M,N);
	}
}
