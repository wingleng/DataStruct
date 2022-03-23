package luogu.p1042;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		//洛谷和力扣不一样，参数居然是从控制台输入的
		StringBuffer sb = new StringBuffer();
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
//		sc.useDelimiter("E");
		do {
			sb.append(sc.next());
		} while (sb.indexOf("E")==-1);
		matchInfo(sb.toString());
	}
	public static void matchInfo(String competions){
		int win = 0;
		int lost = 0;
		for (char s : competions.toCharArray()) {
			if(s=='W')win++;
			if(s=='L')lost++;
			if((win==11 || lost==11)&&Math.abs(win-lost)>2) {
				System.out.println(win+":"+lost);
				win=0;
				lost=0;
			}
			if(s=='E') {
				System.out.println(win+":"+lost);
			}
		}
		win=0;
		lost=0;
		System.out.println();
		for (char s : competions.toCharArray()) {
			if(s=='W')win++;
			if(s=='L')lost++;
			if((win==21 || lost==21)&&Math.abs(win-lost)>2) {
				System.out.println(win+":"+lost);
				win=0;
				lost=0;
			}
			if(s=='E') {
				System.out.println(win+":"+lost);
			}
		}
	}
}
