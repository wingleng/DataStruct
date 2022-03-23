package leetcod._40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和2
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
		Arrays.sort(candidates);//进行去重有一个必要条件，数组必须先进行排序
		boolean[] used = new boolean[candidates.length];//使用一个辅助数组，记录candidates中哪个元素被使用过
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
