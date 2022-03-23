package leetcod._40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ����ܺ�2
 * @author WONG
 *
 */
public class Solution {
	public static void main(String[] args) {
		Solution t = new Solution();
		int[] candians1 = new int[] {10,1,2,7,6,1,5};
		List<List<Integer>> rst = t.combinationSum2(candians1, 8);
		System.out.println(rst);
	}
	
	List<List<Integer>> result = new ArrayList<>();
	LinkedList<Integer> path = new LinkedList<>();
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target){
		Arrays.sort(candidates);//����ȥ����һ����Ҫ��������������Ƚ�������
		boolean[] used = new boolean[candidates.length];//ʹ��һ���������飬��¼candidates���ĸ�Ԫ�ر�ʹ�ù�
		trackback(candidates, target, 0, 0,used);
		return result;
	}
	
	public void trackback(int[] candidates,int target,int sum,int startIndex,boolean used[]) {
		if(sum == target) {
			result.add(new ArrayList<>(path));
			return;
		}
		if(sum > target	) {
			return;
		}
		for(int i=startIndex;i<candidates.length;i++) {
			if(i>0 && candidates[i]==candidates[i-1] &&used[i-1]==false) {
				continue;
			}
			sum += candidates[i];
			path.add(candidates[i]);
			used[i] = true;
			trackback(candidates, target, sum, i+1,used);
			used[i] = false;
			sum -= candidates[i];
			path.removeLast();
		}
	}
}
