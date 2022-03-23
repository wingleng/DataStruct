package leetcod._39;
import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Solution t = new Solution();
		int[] sum1 = new int[] {2,3,6,7};
		List<List<Integer>> rst =  t.combinationSum(sum1, 7);
		System.out.println(rst);
	}
	
	List<List<Integer>> result = new ArrayList<>();
	LinkedList<Integer> path = new LinkedList<>();
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		trackback(candidates, target, 0,0);
		return result;
    }
	public void trackback(int[] candidates,int target,int sum,int startIndex) {
		if(sum > target) {
			return;
		}
		if(sum == target) {
			result.add(new ArrayList<>(path));
			return;
		}
		
		for(int i=startIndex;i<candidates.length;i++) {
			path.add(candidates[i]);
			sum+= candidates[i];
			trackback(candidates, target, sum,i);
			
			sum-= candidates[i];
			path.removeLast();
		}
	}
}
