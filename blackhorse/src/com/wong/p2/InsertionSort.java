package com.wong.p2;

public class InsertionSort {

	//黑马的选择排序
	// 感觉就是不断的将无序区的最左边的元素放进有序区中。然后有序区就将新放进来的元素再次进行排序
	public static void insertionSorted(int[] arr) {
		if(arr == null || arr.length <2) {
			return;
		}
		for(int i = 1;i< arr.length;i++) {//遍历无序区
			for(int j = i-1;j >=0 ;j--) {//遍历有序区
				if(arr[j] > arr[j+1]) {//使有序区按从小到大进行排列，大概吧。
					swap(arr,j,j+1);
				}
			}
		}
		
	}
	
	//使用异或的方式，替换元素。如果i和j是同一个位置的话，会出错
	public static void swap(int[] arr,int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}
	
	
	//测试
	public static void main(String args[]) {
		int[] testArr = new int[]{	7,8,6,1,3,9,55,44};
		
		insertionSorted(testArr);
		
		for(int val:testArr) {
			System.out.printf("%d\t",	val	);
		}
	}
}
