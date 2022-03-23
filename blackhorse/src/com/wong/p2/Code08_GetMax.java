package com.wong.p2;

/**
 * 递归求数组中的最大值
 * @author BENWONG
 *
 */
public class Code08_GetMax {
	
	public static int getMax(int[] arr) {
		return process(arr,0,arr.length-1);
	}
	/** 
	 * 该算法的递归复杂度为T(N) = 2* T(N/2) + O(1)
	 * @param arr
	 * @param L
	 * @param R
	 * @return
	 */
	public static int process(int[] arr,int L,int R	) {
		if(L == R) {
			return arr[L];
		}
		int mid = L + ((R-L)>>1);
		int left = process(arr,L,mid);
		int right = process(arr,mid+1,R);
		return Math.max(left, right);
	}
	
	public static void main(String args[]) {
		int[] testarr = new int[] {
				1,852,9,6423,56,96,575,33
		};
		int res = getMax(testarr);
		System.out.println(res);
	}
}
