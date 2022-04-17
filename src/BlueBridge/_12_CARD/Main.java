package BlueBridge._12_CARD;

import java.util.Scanner;

public class Main {

	/**
	 * ��Ƭ������0~9�Ŀ�Ƭ��2021�ţ���1��ʼ��ϣ�����������϶�����
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
		
		//�������֣�ֱ����Ƭ������λ��
		for(int i=1;;i++) {
			if(!check(i)) {
				System.out.println(i-1);
				break;
			}
		}
	}
	
	public static boolean check(int x) {
		while(x>0) {
			//�ֱ�ȡ��ÿ��λ�õ������鿴�Ƿ���ʣ�µ�
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
