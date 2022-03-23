package leetcod._393;
/**
 * 判断整型数组是否符合UTF-8规范
 * @author WONG
 *
 */
public class Solution {
	public static void main(String[] args) {
		int[] nums = new int[] {197,130,1};
		System.out.println(validUtf8(nums)); 
	}
	static final int MASK1 = 1<<7;//1000 0000
	static final int MASK2 = (1<<7)+(1<<6);//11000000
	public static boolean validUtf8(int[] data) {
		int m = data.length;
		int index = 0; //index表示一个字节的头字符在data数组中的位置
		while(index<m) {
			int num = data[index];//取出头字符
			int n=getBytes(num);//从头字节中获取到该字符到底由多少个字节组成
			if(n<0 || index+n>m) {
				return false;
			}
			
			for(int i=1;i<n;i++) {
				if(!isValid(data[index+i])) {
					return false;
				}
			}
			index+=n;//当前字符判断完成之后，头字节的位置移动到下一个字符
		}
		
		
		return true;
    }
	
	public static int getBytes(int num) {
		if((num & MASK1)==0	) {//如果以0开头，说明是1个字节的字符
			return 1;
		}
		int n=0;//n表示这个字符有多少个字节
		int mask = MASK1;
		while((num & mask)!=0) {
			n++;
			if(n>4) {
				return -1;
			}
			mask >>=1;
		}
		return n>=2?n:-1;
	}
	public static boolean isValid(int num) {
		return (num & MASK2) == MASK1;
	}
	
}
