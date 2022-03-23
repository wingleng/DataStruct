package com.wong._242;

public class Solution {
	public static boolean isAnagram(String s,String t) {
		//���ȱ����ַ���s����¼�ַ����г��ֵ��ַ��Ĵ�����ʹ��asc2��¼
		//Ȼ������ַ���t������Ӧ�ַ���λ�õĴ�����1
		//��������¼���飬�������е������Ƿ�ȫ��Ϊ0
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
