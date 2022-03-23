package leetcod._2049;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {
	public static void main(String[] args) {
		int[] parents = new int[] {-1,2,0,2,0};
		Solution t = new Solution();
		t.countHighestScoreNodes(parents);
	}
	List<Integer>[] childrens;
	Map<Integer, Integer> result;
	public void countHighestScoreNodes(int[] parents) {
		//首先统计出每个节点的子节点，然后进行深度优先遍历，深度遍历过程中，获取每个节点的左右子树，以及其分数
		int n = parents.length;
		childrens = new ArrayList[n];
		result = new HashMap<>();
		for(int i=0;i<n;i++) {
			childrens[i] = new ArrayList<>();
		}
		
		
		for(int i=0;i<n;i++) {
			if(parents[i]!=-1) {
				childrens[parents[i]].add(i);
			}
		}
		
		dfs(0);
		int rst = -1;
		
		
		for (Entry<Integer, Integer> i : result.entrySet()) {
//			System.out.println("分数："+i.getKey()+" => "+i.getValue());
			if (i.getValue()>rst) {
				rst = i.getValue();
			}
		}
		System.out.println(rst);
	}
	
	
	public int dfs(int Node) {
		int n = childrens.length;
		int sub_total = 0;//记录子节点数量
		LinkedList<Integer> sub = new LinkedList();//记录当前层节点的左右子节点
		
		
		for (Integer i:childrens[Node]) {
			sub.add(dfs(i));
			sub_total += sub.getLast();
		}
		
		//计算并且记录每个节点的分数
		int scores = 1;
		int rightTop = n - (sub_total+1);//右上角的父节点
		if(rightTop!=0) scores*=rightTop;
		for (Integer integer : sub) {//左右节点
			if(integer!=0) {//这步很关键。
				scores *=integer;
			}
		}
		//计算该节点分数之后，使用Map进行记录
		result.put(scores, result.getOrDefault(scores, 0)+1);
		
		
		return sub_total+1;
	}
	
}
