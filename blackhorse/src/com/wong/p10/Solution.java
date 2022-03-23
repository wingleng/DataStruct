package com.wong.p10;

import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) {
		func("abc");
		System.out.println("ab0".toCharArray().length);
	}
	public static void func(String string) {
		char[] chs = string.toCharArray();
		process(chs,0);
	}
	public static void process(char[] str,int i) {
		if(i == str.length) {
			System.out.println(String.valueOf(str));
			return ;
		}
		process(str, i+1);//要当前字符的路
		char tmp = str[i];
		str[i] = 0;//清除当前字符
		process(str, i+1);//不要当前字符的路
		str[i] = tmp;//恢复刚才清除的字符，然后返回上一层递归
	}
}
