package BlueBridge._12D;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	/**
	 * 就是给一个数n，分解因数，问能够有多少种方案
	 * 4 = 1*1*4
	 * 4 = 4*1*1
	 * 4 = 1*4*1
	 * 4 = 2*2*1
	 * 4 = 1*2*2
	 * 4 = 2*1*2
	 * 共6种
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//解题思路就是求n有多少个约数，全部记录起来，然后使用三重遍历，直接暴力尝试
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
