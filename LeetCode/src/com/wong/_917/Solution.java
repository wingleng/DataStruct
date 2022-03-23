package com.wong._917;

class Solution {
    public String reverseOnlyLetters(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int left = 0, right = n - 1;
        while (true) {
        	//ɨ�赽������ĸʱָ���ƶ�
            while (left < right && !Character.isLetter(s.charAt(left))) { // �ж�����Ƿ�ɨ�赽��ĸ
                left++;
            }
            while (right > left && !Character.isLetter(s.charAt(right))) { // �ж��ұ��Ƿ�ɨ�赽��ĸ
                right--;
            }
            if (left >= right) {
                break;
            }
            swap(arr, left, right);
            left++;
            right--;
        }
        return new String(arr);
    }

    public void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
