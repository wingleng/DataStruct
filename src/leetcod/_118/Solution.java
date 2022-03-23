package leetcod._118;
import java.util.*;
public class Solution {
	public static void main(String[] args) {
		List<List<Integer>> result = generate(5);
		for (List<Integer> list : result) {
			System.out.println(list);
		}
		System.out.println();
		System.out.println(generateLevel(5));
	}
	public static List<List<Integer>> generate(int numRows) {
        // 生成numRows行的杨辉三角
		List<List<Integer>> result = new ArrayList<>();
		for(int i=0;i<numRows;i++) {
			List<Integer> curlevel = new ArrayList<>();
			for(int j=0;j<=i;j++) {
				if(j==0 || j==i) {
					curlevel.add(1);
				}else {
					curlevel.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
				}
			}
			
			result.add(curlevel);
		}
		return result;
    }
	
	//119题
	public static List<Integer> generateLevel(int rowIndex){
		int[] dp = new int[rowIndex+1];
		for(int i=0;i<=rowIndex;i++) {
			dp[i]=1;
			for(int j=i;j>1;j--) {
				dp[j-1] = dp[j-1]+dp[j-2];
			}
		}
		List<Integer> result = new ArrayList<>();
		for (int i : dp) {
			result.add(i);
		}
		return result;
	}
	
}
