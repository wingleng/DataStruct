package acwing._92;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static int n;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n= scanner.nextInt();
		dfs(0, 0);
	}
	public static void dfs(int u,int state) {
		if(u == n) {
			for(int i=0;i<n;i++) {
				if((state>>i&1)==1) {
					System.out.print(i+1+" ");
				}
			}
			System.out.println();
			return;
		}
		
		dfs(u+1, state);
		dfs(u+1, state | 1 << u);
	}
	
	
}



