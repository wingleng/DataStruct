package leetcod._509;
/**
 * 斐波那契数
 * @author WONG
 *
 */
public class Solution {
	public static void main(String[] args) {
		System.out.println(fib(10));
	}
	public static int fib(int n) {
		//一道经典的动态规划的入门题目
        //1，首先确认dp数组，以及下标的含义。dp[i]的含义是第i个斐波那契数的值
        //2，确定递推公式。题目中已经给出了，dp[i]=dp[i-1]+dp[i-2]，dp[i]的值是前面两项的和
        //3，确认数组如何初始化。题目中已经给出，dp[0]=0，dp[1]=1
        //4，确认遍历顺序。按照题意，是从前遍历到后面
        //5，举例子，推导递推公式是否正确
		
		int a=0;
		int b=1;
		int res=0;
		//遍历从第三个开始。。
		for(int i=2;i<=n;i++) {
			res=b+a;
			a=b;
			b=res;
		}
		return res;
	}
}
