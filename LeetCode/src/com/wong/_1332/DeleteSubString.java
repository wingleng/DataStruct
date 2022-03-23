package com.wong._1332;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
/**
 * 1332. ɾ������������
 * ����һ���ַ��� s����������ĸ 'a' �� 'b' ��ɡ�ÿһ��ɾ�����������Դ� s ��ɾ��һ������ �����С�
 * ����ɾ�������ַ����������ַ����ַ���Ϊ�գ�����Сɾ��������
 * �������С����壺���һ���ַ�������ͨ��ɾ��ԭ�ַ���ĳЩ�ַ������ı�ԭ�ַ�˳��õ�����ô����ַ�������ԭ�ַ�����һ�������С�
 * �����ġ����壺���һ���ַ���������ǰ����һ�µģ���ô����ַ�������һ�����ġ�
 *  @author BENWONG
 *
 */
public class DeleteSubString {
	public static int removePalindromeSub(String s) {
		int n = s.length();
		for(int i = 0;i<n/2;++i) {
			if(s.charAt(i) != s.charAt(n-1-i)) {
				return 2;
			}
		}
		return 1;
	}
	
	public static void main(String args[]) {
		String s1 = "ababa";
		String s2 = "abb";
		String s3 = "baabb";
		String s4 = "abbabbbaa";
	
		int rst1 = removePalindromeSub(s1);   
		int rst2 = removePalindromeSub(s2);  
		int rst3 = removePalindromeSub(s3);
		int rst4 = removePalindromeSub(s4);
	
		System.out.printf("%d %d %d %d", rst1,rst2,rst3,rst4);
	}
}