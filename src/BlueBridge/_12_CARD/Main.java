package BlueBridge._12_CARD;

import java.util.Scanner;

public class Main {

	/**
	 * 卡片，给你0~9的卡片各2021张，从1开始组合，问最多可以组合多大的数
	 * @param args
	 */
	public static int[] cards;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scanner = new Scanner(System.in);
//		int n = scanner.nextInt();
//		
		cards = new int[10]; 
		for(int i=0;i<10;i++) {
			cards[i] = 2021;
		}
		
		//遍历数字，直到卡片不够用位置
		for(int i=1;;i++) {
			if(!check(i)) {
				System.out.println(i-1);
				break;
			}
		}
	}
	
	public static boolean check(int x) {
		while(x>0) {
			//分别取出每个位置的数，查看是否还有剩下的
			int single = x%10;
			x /=10;
			cards[single]-=1;
			if(cards[single]<0	) {
				return false;
			}
		}
		return true;
	}

}
