package black_horse.p10.kmp;

public class Solution {
	 public static int getIndexOf(String s, String m) {
	        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
	            return -1;
	        }
	        char[] str1 = s.toCharArray();
	        char[] str2 = m.toCharArray();
	        int i1 = 0;//i1��str1�бȶԵ�λ��
	        int i2 = 0;//i2��str2�бȶԵ�λ��
	        int[] next = getNextArray(str2);//�õ���str2��next����
	        //O(N)
	        while (i1 < str1.length && i2 < str2.length) {
	            if (str1[i1] == str2[i2]) {//��ȵ�ʱ������str��λ�ö���ǰ�ƽ�
	                i1++;
	                i2++;
	            } else if (next[i2] == -1) {//���Ի���i2==0 ��next[i2]=-1(str2��next����ģ���0��λ�ã���Ϊ�涨��ֵΪ-1)
	                i1++;//��Ȼstr2,�Ѿ���ͷ�ˣ�����ֻ����str1��λ�ý��бȶ���
	            } else {//�÷�֧��ʾstr2���ܼ�����ǰ��
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
