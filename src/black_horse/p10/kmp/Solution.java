package black_horse.p10.kmp;

public class Solution {
	 public static int getIndexOf(String s, String m) {
	        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
	            return -1;
	        }
	        char[] str1 = s.toCharArray();
	        char[] str2 = m.toCharArray();
	        int i1 = 0;//i1是str1中比对的位置
	        int i2 = 0;//i2是str2中比对的位置
	        int[] next = getNextArray(str2);//得到了str2的next数组
	        //O(N)
	        while (i1 < str1.length && i2 < str2.length) {
	            if (str1[i1] == str2[i2]) {//相等的时候，两个str的位置都向前推进
	                i1++;
	                i2++;
	            } else if (next[i2] == -1) {//可以换成i2==0 或next[i2]=-1(str2的next数组的，在0的位置，认为规定其值为-1)
	                i1++;//既然str2,已经到头了，所以只能让str1换位置进行比对了
	            } else {//该分支表示str2还能继续往前跳
	                i2 = next[i2];
	            }
	        }
	        return i2 == str2.length ? i1 - i2 : -1;
	    }
	    public static int[] getNextArray(char[] ms) {
	        if (ms.length == 1) {
	            return new int[] { -1 };
	        }
	        int[] next = new int[ms.length];
	        next[0] = -1;
	        next[1] = 0;
	        int i = 2;
	        int cn = 0;
	        while (i < next.length) {
	            if (ms[i - 1] == ms[cn]) {
	                next[i++] = ++cn;
	            } else if (cn > 0) {
	                cn = next[cn];
	            } else {
	                next[i++] = 0;
	            }
	        }
	        return next;
	    }
	    public static void main(String[] args) {
	        String str = "abcabcababaccc";
	        String match = "ababa";
	        System.out.println(getIndexOf(str, match));
	    }

}
