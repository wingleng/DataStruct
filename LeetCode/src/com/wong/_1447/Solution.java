package com.wong._1447;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	/**
	 * 直接求分子和分母之间的公约数，最大公约数为1，即可。
	 * @param a
	 * @return
	 */
	public static List<String> simplifiedFractions(int a){
		List<String> ans = new ArrayList<String>();
		for(int d = 2;d<=a;++d) {
			for(int n = 1;n<d;++n) {
				if(gcd(d,n) == 1) {
					ans.add(n + "/" + d);
				}
			}
		}
		return ans;
	}
	public static int gcd(int a,int b) {
		return b !=0? gcd(b, a %b):a;
	}
	public static void main(String[] args) {
		List<String> result = simplifiedFractions(3);
		for(String string:result) {
			System.out.println(string);
		}
	}
}
