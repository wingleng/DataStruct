package leetcod._693;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		int n= 11;
		boolean F = false;
		List<Integer> bitlist = new ArrayList<>();
		while(n>0) {
			System.out.printf("%d ",n & 1);
			
			F = (n&1)==1?true:false;
			
			System.out.println(F);
			n>>=1;	
		}

	}
}
