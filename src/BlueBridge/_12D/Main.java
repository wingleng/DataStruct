package BlueBridge._12D;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	/**
	 * ���Ǹ�һ����n���ֽ����������ܹ��ж����ַ���
	 * 4 = 1*1*4
	 * 4 = 4*1*1
	 * 4 = 1*4*1
	 * 4 = 2*2*1
	 * 4 = 1*2*2
	 * 4 = 2*1*2
	 * ��6��
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����˼·������n�ж��ٸ�Լ����ȫ����¼������Ȼ��ʹ�����ر�����ֱ�ӱ�������
		Scanner scanner = new Scanner(System.in);
		Long n = scanner.nextLong();
		
		
		List<Long> list = new ArrayList<>();
		for(long i=1;i*i<=n;i++) {
			if(n%i==0) {
				list.add((long) i);
				if(n/i!=i)list.add(n/i);
			}
		}
		int res =0;
		for (Long a : list) {
			for (Long b : list) {
				for(Long c:list) {
					if(a*b*c==n) {
						res++;
					}
				}
			}
		}
		System.out.println(res);
	}

}
