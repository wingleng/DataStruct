package leetcod._455;

import java.util.Arrays;
import java.util.Iterator;


public class Solution {
	public static void main(String[] args) {
		int g[] = new int[] {1,2,3};
		int s[] = new int[] {1,1};
		Solution t = new Solution();
		int result = t.findContentChildren(g, s);
		System.out.println(result);
	}
	public int findContentChildren(int[] g,int s[]){
		Arrays.sort(g);
		Arrays.sort(s);
		int index = s.length-1;//����������±�
		int result = 0;
		
		//�Ӻ���ǰ����С������
		for(int i=g.length-1;i>=0;i--) {
			if(index>=0 && s[index]>=g[i]) {
				result++;
				index++;
			}
		}
		return result;
	}

}
