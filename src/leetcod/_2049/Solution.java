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
		//����ͳ�Ƴ�ÿ���ڵ���ӽڵ㣬Ȼ�����������ȱ�������ȱ��������У���ȡÿ���ڵ�������������Լ������
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
//			System.out.println("������"+i.getKey()+" => "+i.getValue());
			if (i.getValue()>rst) {
				rst = i.getValue();
			}
		}
		System.out.println(rst);
	}
	
	
	public int dfs(int Node) {
		int n = childrens.length;
		int sub_total = 0;//��¼�ӽڵ�����
		LinkedList<Integer> sub = new LinkedList();//��¼��ǰ��ڵ�������ӽڵ�
		
		
		for (Integer i:childrens[Node]) {
			sub.add(dfs(i));
			sub_total += sub.getLast();
		}
		
		//���㲢�Ҽ�¼ÿ���ڵ�ķ���
		int scores = 1;
		int rightTop = n - (sub_total+1);//���Ͻǵĸ��ڵ�
		if(rightTop!=0) scores*=rightTop;
		for (Integer integer : sub) {//���ҽڵ�
			if(integer!=0) {//�ⲽ�ܹؼ���
				scores *=integer;
			}
		}
		//����ýڵ����֮��ʹ��Map���м�¼
		result.put(scores, result.getOrDefault(scores, 0)+1);
		
		
		return sub_total+1;
	}
	
}
