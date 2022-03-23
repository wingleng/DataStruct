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
		 * ����˼·������Ҫ���ַ������鰴����������ȷ�������ַ������ȴӶ̵�������
		 * Ȼ��������飬����ǰ�ַ���-1֮����Ӵ��Ƿ��ڹ�ϣ���ϵ��У�����ڣ���˵����������������´𰸣�������ڹ�ϣ�����У��ͽ���ǰ�ַ����Ž���ϣ������
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
