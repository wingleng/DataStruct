package leetcod._509;
/**
 * 쳲�������
 * @author WONG
 *
 */
public class Solution {
	public static void main(String[] args) {
		System.out.println(fib(10));
	}
	public static int fib(int n) {
		//һ������Ķ�̬�滮��������Ŀ
        //1������ȷ��dp���飬�Լ��±�ĺ��塣dp[i]�ĺ����ǵ�i��쳲���������ֵ
        //2��ȷ�����ƹ�ʽ����Ŀ���Ѿ������ˣ�dp[i]=dp[i-1]+dp[i-2]��dp[i]��ֵ��ǰ������ĺ�
        //3��ȷ��������γ�ʼ������Ŀ���Ѿ�������dp[0]=0��dp[1]=1
        //4��ȷ�ϱ���˳�򡣰������⣬�Ǵ�ǰ����������
        //5�������ӣ��Ƶ����ƹ�ʽ�Ƿ���ȷ
		
		int a=0;
		int b=1;
		int res=0;
		//�����ӵ�������ʼ����
		for(int i=2;i<=n;i++) {
			res=b+a;
			a=b;
			b=res;
		}
		return res;
	}
}
