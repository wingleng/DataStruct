package leetcod._172;

public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.process(15));
		System.out.println(s.NumberOfZero(12001));
	}
	public int process(int n) {
		if(n== 1) {
			return 1;
		}
		return n*process(n-1);
	}
	//检查数字后面有多少个0
	public int NumberOfZero(int n) {
		int number = 0;
		while(n>0) {
			int s = n%10;
			n/=10;
			if(s==0) {
				number++;
			}else {
				break;
			}
		}
		return number;
		
	}
}
