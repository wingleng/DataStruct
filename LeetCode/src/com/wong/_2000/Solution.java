package com.wong._2000;

public class Solution {
	/**
	 * 我自己的解法，直接使用遍历，找到开始和结束下标
	 * @param word
	 * @param ch
	 * @return
	 */
	public static String reversePrefix(String word,char ch) {
		//本质就是求起始下标和结束下标
		int start = 0;
		int end = 0;
		for(int i=0;i<word.length();i++) {
			if(word.charAt(i) == ch) {
				end = i+1;
				break;
			}
		}
		//如果起始下标和结束下标一致，就直接返回原字符串
		if(start == end) {
			return word	;
		}
		//如果不一致的话，就将两个下标区间的字符串反转之后返回
		String subStr =new StringBuffer(word.substring(start, end)).reverse().toString() ;
		String rst = new StringBuffer(word).replace(start, end, subStr).toString();
		return rst;
	}
	
	/**
	 * LeetCode的解法，看起来差不多，使用了String 中的内置方法进行查找。但是反转字符串的部分自己手动反转了，估计是Java默认的反转空间复杂度太高了
	 * @param word
	 * @param ch
	 * @return
	 */
	public static String reversePrefix2(String word,char ch) {
		int end = word.indexOf(ch);
		if(end >=0) {
			char[] arr = word.toCharArray();
			int left=0,right=end;
			while(left < right) {
				char tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
				left++;
				right--;
			}
			word = new String(arr);
		}
		return word;
	}
	
	
	public static void main(String[] args) {
		String word = "abcdefd";
		char ch = 'd';
		
		String word2 = "xyxzxe";
		char ch2 = 'z';
		String result = reversePrefix(word2, ch2);
		System.out.println(result);
	}
}
