package leetcod._15;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {-1,0,1,2,-1,-4};
		List<List<Integer>> rstList = threeSum(nums);
		for (List<Integer> list : rstList) {
			System.out.println(list);
		}
		
	}
	  public static List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> result = new ArrayList<>();
	        Arrays.sort(nums);
	        int len = nums.length;
	       
	        for(int i=0;i<len;i++) {
	        	if(nums[i]>0)return result;
	        	if(i>0&&nums[i]==nums[i-1])continue;
	        	int L = i+1;
	        	int R = len-1;
	        	int curr = nums[i];
	        	while(L<R) {
	        		int temp = curr + nums[L] + nums[R];
	        		if(temp == 0) {
	        			List<Integer> list = new ArrayList<>();
	        			list.add(curr);
	        			list.add(nums[L]);
	        			list.add(nums[R]);
	        			result.add(list);
	        			while(L<R && nums[L+1] == nums[L])L++;
	        			while(L<R && nums[R-1] == nums[R])R--;
	        			L++;
	        			R--;
	        		}
	        		//如果temp大于0，说明nums[R]大了
	        		else if(temp>0) {
	        			--R;
	        		}
	        		else{
	        			++L;
	        		}
	        	}
	        }
	       
	        return result;
	    }

}
