package leetcod._6;

/**
 * Z字形变换
 * @author WONG
 *
 */
public class Solution {
	public static void main(String[] args) {
		String s="PAYPALISHIRING";
		int n = 3;
		convert(s, n);
	}
	public static String convert(String str,int numRows) {
		//采用模拟的手段
		//r为向下填写的字符数量，r-2为向右上角填写的字符数量。
		//周期为2r-2个字符，每个周期占用列为r-1列。
		return "";
	}
}