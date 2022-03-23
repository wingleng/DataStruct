package leetcod._17;
/**
 * 力扣第17题，问9宫格按键的老年人手机，给出数字，能够对应出多少字母
 * 回溯算法的问题
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
	//每个数字按键和字母的映射
	String[] numberMap = new String[] {
		"","","abc","def","hij","jkl","mno","pqrs","tuv","wxyz"
	};
	
	List<String> result = new ArrayList<>();//结果
	StringBuffer path = new StringBuffer();//单个结果
	public List<String> letterCombinations(String digits){
		//回溯算法问题，这道题目要解决的应该是每个按键所对应的字母。然后每个按键的字母可以组合出多少个不同的字符串。
		//看代码随想录的文章，单个按键对应的字母构成了一个集合。然后构成的树的深度为给出的按键的字符串的长度
		trackback(digits, 0);
		return result;
	}
	public void trackback(String digits,int startIdx) {
		if(startIdx==digits.length()) {
			result.add(path.toString());
			return ;
		}
		System.out.println("当前在的层："+startIdx);
		//单层循环逻辑
		int digt = digits.charAt(startIdx) - '0';
		String letters = numberMap[digt];
		for(int i=0;i<letters.length();i++) {
			path.append(letters.charAt(i));
			trackback(digits, startIdx+1);
			path.deleteCharAt(path.length()-1);
		}
	}
}
