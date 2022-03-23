package com.wong._50;

/**
 * leetcode第50题，快速幂
 * @author BENWONG
 *
 */
public class Solution {
	public static void main(String[] args) {
		double result = myPow(2.00000, -2);
		System.out.println(result);
	}
	
	
	public static double myPow(double x,int n) {
		double result = 0;
		if(n>0) {
			result = process2(x, n);
		}
		if(n<0) {
			result = 1.0 / process2(x, Math.abs(n));
		}
		return result;
		
	}
	
	//这个递归是很蠢的递归方式，指数是每次+1，计算方式很慢
	public static double process(double x,int n) {
		if(n == 1)return x;
		double rst;
		rst = x * process(x, n-1);
		return rst;
	}
	
	//官网的递归方式，指数每次/2，
	public static double process2(double x,int n) {
		if(n == 0)return 1.0;
		double y = process2(x, n/2);
		return n % 2==0?y*y:y*y*x;
	}
}
