package leetcod._720;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		String[] strings = new String[] {"w","wo","wor","worl", "world"};
		System.out.println(longestWord(strings));
	}
	public static String longestWord(String[] strings) {
		/**
		 * 解题思路：首先要将字符串数组按照升序排序，确保按照字符串长度从短到长排序。
		 * 然后遍历数组，看当前字符串-1之后的子串是否在哈希集合当中，如果在，则说明符合条件，则更新答案；如果不在哈希集合中，就将当前字符串放进哈希集合中
		 */
		Arrays.sort(strings,(a,b)->{
			if(((String) a).length()!=((String) b).length()) {
				return a.length() - b.length();
			}else {
				return b.compareTo(a);
			}
		});
		Set<String> set = new HashSet<>();
		set.add("");
		String result = "";
		for (String string : strings) {
			if(set.contains(string.substring(0, string.length()-1))) {
				result = string;
				set.add(string);
			}
		}
		return result;
		
	}
}
