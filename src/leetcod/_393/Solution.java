package leetcod._393;
/**
 * �ж����������Ƿ����UTF-8�淶
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
		int index = 0; //index��ʾһ���ֽڵ�ͷ�ַ���data�����е�λ��
		while(index<m) {
			int num = data[index];//ȡ��ͷ�ַ�
			int n=getBytes(num);//��ͷ�ֽ��л�ȡ�����ַ������ɶ��ٸ��ֽ����
			if(n<0 || index+n>m) {
				return false;
			}
			
			for(int i=1;i<n;i++) {
				if(!isValid(data[index+i])) {
					return false;
				}
			}
			index+=n;//��ǰ�ַ��ж����֮��ͷ�ֽڵ�λ���ƶ�����һ���ַ�
		}
		
		
		return true;
    }
	
	public static int getBytes(int num) {
		if((num & MASK1)==0	) {//�����0��ͷ��˵����1���ֽڵ��ַ�
			return 1;
		}
		int n=0;//n��ʾ����ַ��ж��ٸ��ֽ�
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
