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
	 * 每个字符串的价值都是 1（对答案的贡献都是 1），选择的成本是该字符串中 1 的数量和 0 的数量。
		问我们在 1 的数量不超过 mm，0 的数量不超过 nn 的条件下，最大价值是多少
	 * @param strs
	 * @param m
	 * @param n
	 * @return
	 */
	public static int findMaxForm(String[] strs, int m, int n) {
		//m，n是背包的两个维度。0的数量和1的数量是物品的两个维度？
		int zeroNum;
		int oneNum;
		int[][] dp = new int[m+1][n+1];//dp[i][j]的含义是含有i个0，j个1的strs的最大子集数量；
		
		for(String string:strs) {
			
			zeroNum = 0;
			oneNum = 0;
			
			for(char c:string.toCharArray()) {
				if(c == '0')zeroNum++;
				else oneNum++;
			}
			
			//此处嵌套在循环里面是因为需要依次获取每个字符串0和1的数量。如果，oneNum和zeroNum做成数组（即类似weight数组，则可以不用嵌套在循环当中）
			for(int i=m;i>=zeroNum;i--) {
				for(int j=n;j>=oneNum;j--) {
					dp[i][j] = Math.max(dp[i][j], dp[i-zeroNum][j-oneNum]+1);//加一？
				}
			}
			
		}
		
		return dp[m][n];
		
	}
	
//	public static int findMaxForm2(String[] strs, int m, int n) {
//			int len = strs.length;
//			int[][] zeroAndOnes = new int[len][2];
//			//收集成本信息，即每个字符串的0和1的数量，
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
//			//开始dp五部曲
//			/* 
//			 * 1.dp[i][j]的含义：
//			 * 		一个str就是一个物品，而str的成本有两个，分别为这个字符串所包含的1的数量和0的数量。dp[i][j]就是i个0，j个1时，背包所容纳的最大价值。
//			 * 2. 递推公式：
//			 * 		一个str就是一个物品，但是一个str的价值就只有1。因为看示例，一个有四个str的集合，价值只有四，所以认为一个str的价值为1。
//			 * 		可得递推公式(这里是压缩空间版)：
//			 * 		dp[i][j] = Math.max(dp[i][j],dp[i-zeroAndOnes[i][0]][j-zeroAndOnes[i][1]]+1);
//			 * 3. dp的初始化：
//			 * 		dp[0][0] = 0;即可
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
