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
		process(str, i+1);//Ҫ��ǰ�ַ���·
		char tmp = str[i];
		str[i] = 0;//�����ǰ�ַ�
		process(str, i+1);//��Ҫ��ǰ�ַ���·
		str[i] = tmp;//�ָ��ղ�������ַ���Ȼ�󷵻���һ��ݹ�
	}
}
