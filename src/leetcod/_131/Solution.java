package leetcod._131;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * �ָ�����Ӵ�
 * @author WONG
 *
 */
public class Solution {
	public static void main(String[] args) {
		String strs = "aab";
		Solution t = new Solution();
		List<List<String>> rstList = t.partition(strs);
		for (List<String> list : rstList) {
			System.out.println(list);
		}
	}
	
	Deque<String> path = new LinkedList();//���õ��������Ӵ�
	public List<List<String>> result = new ArrayList<>();//���ý��
	public List<List<String>> partition(String s) {
		trackback(s, 0);
		return result;
    }
	
	public void trackback(String s,int startIndex) {
		if(startIndex>=s.length()) {
			result.add(new ArrayList<>(path));
			return ;
		}
		for(int i=startIndex;i<s.length();i++) {
			if(isPalindrome(s,startIndex,i)) {
				String string = s.substring(startIndex, i+1);
				path.addLast(string);
			}else {
				continue;
			}
			trackback(s, i+1);
			path.removeLast();
		}
		
	}
	//�ж��������ڵ��ַ��Ƿ�Ϊ�����ַ���
	private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
