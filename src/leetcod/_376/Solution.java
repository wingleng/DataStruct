package leetcod._376;

/**
 * 摆动序列
 * @author WONG
 *
 */
public class Solution {
	public static void main(String[] args) {
		Solution t = new Solution();
		int[] nums = new int[] {1, 7, 4, 9, 2, 5};
		int result = t.wiggleMaxLength(nums);
		System.out.println(result);
	}
	public int wiggleMaxLength(int[] nums) {
		if(nums.length<=1) {
			return nums.length;
		}
		int preDiff = 0;//前面一对的差值
		int curDiff = 0;//后面一对的差值
		int result = 1;//结果数量，但是不知道初始值为0
		for(int i=0;i<nums.length-1;i++) {
			curDiff = nums[i+1] - nums[i];
			if(curDiff>0 && preDiff<=0 || preDiff>=0&&curDiff<0) {
				result++;
				preDiff = curDiff;
			}
		}
		
		return result;
	}
}
