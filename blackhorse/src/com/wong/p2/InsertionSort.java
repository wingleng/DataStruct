package com.wong.p2;

public class InsertionSort {

	//�����ѡ������
	// �о����ǲ��ϵĽ�������������ߵ�Ԫ�طŽ��������С�Ȼ���������ͽ��·Ž�����Ԫ���ٴν�������
	public static void insertionSorted(int[] arr) {
		if(arr == null || arr.length <2) {
			return;
		}
		for(int i = 1;i< arr.length;i++) {//����������
			for(int j = i-1;j >=0 ;j--) {//����������
				if(arr[j] > arr[j+1]) {//ʹ����������С����������У���Űɡ�
					swap(arr,j,j+1);
				}
			}
		}
		
	}
	
	//ʹ�����ķ�ʽ���滻Ԫ�ء����i��j��ͬһ��λ�õĻ��������
	public static void swap(int[] arr,int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}
	
	
	//����
	public static void main(String args[]) {
		int[] testArr = new int[]{	7,8,6,1,3,9,55,44};
		
		insertionSorted(testArr);
		
		for(int val:testArr) {
			System.out.printf("%d\t",	val	);
		}
	}
}
