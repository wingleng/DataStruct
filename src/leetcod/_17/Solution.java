package leetcod._17;
/**
 * ���۵�17�⣬��9���񰴼����������ֻ����������֣��ܹ���Ӧ��������ĸ
 * �����㷨������
 * @author WONG
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Solution {
	public static void main(String[] args) {
		Solution t = new Solution();
		List<String> rst = t.letterCombinations("23");
		System.out.println(rst);
	}
	//ÿ�����ְ�������ĸ��ӳ��
	String[] numberMap = new String[] {
		"","","abc","def","hij","jkl","mno","pqrs","tuv","wxyz"
	};
	
	List<String> result = new ArrayList<>();//���
	StringBuffer path = new StringBuffer();//�������
	public List<String> letterCombinations(String digits){
		//�����㷨���⣬�����ĿҪ�����Ӧ����ÿ����������Ӧ����ĸ��Ȼ��ÿ����������ĸ������ϳ����ٸ���ͬ���ַ�����
		//����������¼�����£�����������Ӧ����ĸ������һ�����ϡ�Ȼ�󹹳ɵ��������Ϊ�����İ������ַ����ĳ���
		trackback(digits, 0);
		return result;
	}
	public void trackback(String digits,int startIdx) {
		if(startIdx==digits.length()) {
			result.add(path.toString());
			return ;
		}
		System.out.println("��ǰ�ڵĲ㣺"+startIdx);
		//����ѭ���߼�
		int digt = digits.charAt(startIdx) - '0';
		String letters = numberMap[digt];
		for(int i=0;i<letters.length();i++) {
			path.append(letters.charAt(i));
			trackback(digits, startIdx+1);
			path.deleteCharAt(path.length()-1);
		}
	}
}
