package com.wong._1791;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {
	/**
	 * �ⷨһ
	 * @param edges
	 * @return
	 */
	public static int findCenter(int[][] edges) {
		//ֱ�ӱ����ݹ飬ͳ�Ƴ����������Ľڵ㣬����ڵ�϶������Ľڵ�
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<edges.length;i++) {
			if(map.get(edges[i][0]) == null) {
				map.put(edges[i][0], 1);
			}else {
				map.put(edges[i][0], map.get(edges[i][0])+1);
			}
			
			
			if(map.get(edges[i][1]) == null) {
				map.put(edges[i][1], 1);
			}else {
				map.put(edges[i][1], map.get(edges[i][1])+1);
			}
		}
		int max = -1;
		for(Entry<Integer, Integer> e:map.entrySet()) {
			System.out.println("�ڵ㣺"+e.getKey()+"�����ֵĴ�����"+e.getValue());
			if(e.getValue()>max) {
				max = e.getKey();
			}
		}
		System.out.println("���ִ������Ľڵ�:"+max);
		
		return max;
	}
	
	/**
	 * �ⷨ��
	 * @param args
	 */
	public static int findcenter2(int[][] edges) {
		        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
	}
	
	
	public static void main(String[] args) {
		int[][] edges = new int[][] {{1,2},{2,3},{4,2}};
		int[][] edges2 = new int[][] {{1,2},{5,1},{1,3},{1,4}};
		findCenter(edges);
		findCenter(edges2);
	}
}
