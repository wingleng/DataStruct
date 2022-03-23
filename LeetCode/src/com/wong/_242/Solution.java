package com.wong._242;

public class Solution {
	public static boolean isAnagram(String s,String t) {
		//首先遍历字符串s，记录字符串中出现的字符的次数，使用asc2记录
		//然后遍历字符串t，将相应字符的位置的次数减1
		//最后遍历记录数组，看数组中的数据是否全部为0
		int record[] = new int[26];
		
		for(char c:s.toCharArray()) {
			record[c - 'a'] +=1;
		}
		
		for(char c:t.toCharArray()) {
			record[c - 'a'] -=1;
		}
		
		for(int i:record) {
			if(i!=0) {
				return false;
			}
		}
		
		return true;
	}
	public static void main(String[] args) {
		String s1 = "anagram";
		String s2 = "nagaram";
		String ss1 = "rat";
		String ss2 = "car";
		
		boolean rst1 = isAnagram(s1, s2);
		boolean rst2 = isAnagram(ss1, ss2);
		
		System.out.println(rst1);
		System.out.println(rst2);
	}
}
