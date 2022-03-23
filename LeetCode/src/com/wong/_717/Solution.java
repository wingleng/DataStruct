package com.wong._717;

public class Solution {
	public static void main(String[] args) {
		int[] bits = new int[] {1,0,0};
		int[] bits2 = new int[] {1,1,1,0};
		int[] bits3 = new int[] {1,1,0};
		System.out.println(func(bits)); 
		System.out.println(func(bits2));
		System.out.println(func(bits3));
	}
	public static boolean func(int[] bits) {
		 if(bits.length >=2){
				if(bits[bits.length-2]==0) return true;
				int count = 0;//统计数组最后连续1的数量
				for(int i=bits.length-2;i>=0;i--) {
					if(bits[i]==1) count++;
					else break;
				}
				if(count%2==0)return true;
				else return false;
		}
	    if(bits[0]==0) return true;
	    return false;
	}
}
