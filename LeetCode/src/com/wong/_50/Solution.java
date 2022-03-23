package com.wong._50;

/**
 * leetcode��50�⣬������
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
	
	//����ݹ��Ǻܴ��ĵݹ鷽ʽ��ָ����ÿ��+1�����㷽ʽ����
	public static double process(double x,int n) {
		if(n == 1)return x;
		double rst;
		rst = x * process(x, n-1);
		return rst;
	}
	
	//�����ĵݹ鷽ʽ��ָ��ÿ��/2��
	public static double process2(double x,int n) {
		if(n == 0)return 1.0;
		double y = process2(x, n/2);
		return n % 2==0?y*y:y*y*x;
	}
}
