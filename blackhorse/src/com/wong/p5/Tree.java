package com.wong.p5;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.wong.p5.Node;
public class Tree {
	/**
	 * ����������������
	 */
	public static int getMaxWidth(Node head) {
		if(head == null) {
			return 0;
		}
		//��Ҫ��������������һ���ǵ�ǰ������һ���ǵ�ǰ��Ľڵ������ܺͣ�һ����maxֵ��һ�����С�
		int curLevel = 1;
		int curLevelNodes = 0;
		int max = Integer.MIN_VALUE;
		Queue<Node> queue = new LinkedList<Node>();
		Map<Node, Integer> map = new HashMap<Node, Integer>();
		
		//��ʼʱֻ����ͷ�ڵ�
		queue.add(head);
		map.put(head, 1);
		
		//��ʼ����
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			int curNodeLevel = map.get(cur);//��ȡ�����ڵ����ڵĲ���
			
			//�жϵ����ڵ����ڵĲ����Ƿ��뵱ǰҪ�����Ĳ����Ƿ�һ�£����һ�£���ǰ��ڵ���++�����򣬽��㵱ǰ�㣬�������ýڵ���
			if(curNodeLevel == curLevel) {
				curLevelNodes++;
			}
			else {
				max = Math.max(max, curLevelNodes);
				curLevelNodes = 1;
				curLevel++;
			}
			
			//����ǰ�ڵ�����Һ��ӽڵ㣬���뵽hashmap�У�������һ��ѭ��ʱʹ��
			if(head.left!=null) {
				map.put(cur.left, curNodeLevel++);
				queue.add(cur.left);
			}
			if(head.right!=null) {
				map.put(cur.right,curNodeLevel++);
				queue.add(cur.right);
			}
		}
		
		//��������յ�Ļ˵��bug�����һ��Ľڵ���û��ͳ�Ƶ��ġ�
		return max;
	}
	
	public static void main(String[] args) {
		
	}
}
