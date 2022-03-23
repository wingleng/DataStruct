package com.wong._1332;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
/**
 * 1332. 删除回文子序列
 * 给你一个字符串 s，它仅由字母 'a' 和 'b' 组成。每一次删除操作都可以从 s 中删除一个回文 子序列。
 * 返回删除给定字符串中所有字符（字符串为空）的最小删除次数。
 * 「子序列」定义：如果一个字符串可以通过删除原字符串某些字符而不改变原字符顺序得到，那么这个字符串就是原字符串的一个子序列。
 * 「回文」定义：如果一个字符串向后和向前读是一致的，那么这个字符串就是一个回文。
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