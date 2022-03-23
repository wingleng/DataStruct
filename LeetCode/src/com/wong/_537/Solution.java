package com.wong._537;
public class Solution {
	public static void main(String[] args) {
		complexNumberMultiply("1+1i", "1+1i");
	}
	public static String complexNumberMultiply(String num1,String num2) {
		//首先需要将数字的实部和虚部先分开
		String[] complex1 = num1.split("\\+|i");
		String[] complex2 = num2.split("\\+|i");
		System.out.println(complex1[0]+"  " +complex1[1]);
		System.out.println(complex2[0]+"  " +complex2[1]);
		int real1 = Integer.parseInt(complex1[0]);
		int img1 = Integer.parseInt(complex2[1]);
		int real2 = Integer.parseInt(complex2[0]);
		int img2 = Integer.parseInt(complex2[1]);
		
		return "";
	}
}