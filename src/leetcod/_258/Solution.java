package leetcod._258;

public class Solution {
	public static void main(String[] args) {
		
		int n = 123456;
		int sum = 0;
		while(n>10) {
			sum+=n%10;
			n = n/10;
		}
		System.out.println(sum+1);
	}
	public static int addDitgit(int nums) {
		return 0;
	}
	public int process(int n) {
		if(n<10) {
			return n;
		}
		return 0;
	}
}
