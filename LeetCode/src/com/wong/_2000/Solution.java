package com.wong._2000;

public class Solution {
	/**
	 * ���Լ��Ľⷨ��ֱ��ʹ�ñ������ҵ���ʼ�ͽ����±�
	 * @param word
	 * @param ch
	 * @return
	 */
	public static String reversePrefix(String word,char ch) {
		//���ʾ�������ʼ�±�ͽ����±�
		int start = 0;
		int end = 0;
		for(int i=0;i<word.length();i++) {
			if(word.charAt(i) == ch) {
				end = i+1;
				break;
			}
		}
		//�����ʼ�±�ͽ����±�һ�£���ֱ�ӷ���ԭ�ַ���
		if(start == end) {
			return word	;
		}
		//�����һ�µĻ����ͽ������±�������ַ�����ת֮�󷵻�
		String subStr =new StringBuffer(word.substring(start, end)).reverse().toString() ;
		String rst = new StringBuffer(word).replace(start, end, subStr).toString();
		return rst;
	}
	
	/**
	 * LeetCode�Ľⷨ����������࣬ʹ����String �е����÷������в��ҡ����Ƿ�ת�ַ����Ĳ����Լ��ֶ���ת�ˣ�������JavaĬ�ϵķ�ת�ռ临�Ӷ�̫����
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
