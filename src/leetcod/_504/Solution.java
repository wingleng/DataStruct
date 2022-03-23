package leetcod._504;

public class Solution {
	public static void main(String[] args) {
		int num = 100;
		Solution solution = new Solution();
		String result = solution.convertToBase7(num);
		System.out.println(result);
	}
	 public String convertToBase7(int num) {
		//将一个整数转化为一个7进制数。
		 if(num == 0) {
			 return "0";
		 }
		 boolean isNagative = num<0;
		 StringBuffer sb = new StringBuffer();
		 num = Math.abs(num);
		 while(num>0) {
			 sb.append(num%7);
			 num = num/7;
		 }
		 if(isNagative) {
			 sb.append("-");
		 }
		 return sb.reverse().toString();
	 }
	 
}
