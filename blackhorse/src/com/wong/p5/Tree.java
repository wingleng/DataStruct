package com.wong.p5;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.wong.p5.Node;
public class Tree {
	/**
	 * 计算二叉树的最大宽度
	 */
	public static int getMaxWidth(Node head) {
		if(head == null) {
			return 0;
		}
		//需要三个辅助变量，一个是当前层数，一个是当前层的节点数量总和，一个是max值，一个队列。
		int curLevel = 1;
		int curLevelNodes = 0;
		int max = Integer.MIN_VALUE;
		Queue<Node> queue = new LinkedList<Node>();
		Map<Node, Integer> map = new HashMap<Node, Integer>();
		
		//初始时只放入头节点
		queue.add(head);
		map.put(head, 1);
		
		//开始处理
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			int curNodeLevel = map.get(cur);//获取弹出节点所在的层数
			
			//判断弹出节点所在的层数是否与当前要遍历的层数是否一致，如果一致，当前层节点数++。否则，结算当前层，并且重置节点数
			if(curNodeLevel == curLevel) {
				curLevelNodes++;
			}
			else {
				max = Math.max(max, curLevelNodes);
				curLevelNodes = 1;
				curLevel++;
			}
			
			//将当前节点的左右孩子节点，放入到hashmap中，方便下一次循环时使用
			if(head.left!=null) {
				map.put(cur.left, curNodeLevel++);
				queue.add(cur.left);
			}
			if(head.right!=null) {
				map.put(cur.right,curNodeLevel++);
				queue.add(cur.right);
			}
		}
		
		//这个程序按照弹幕说有bug，最后一层的节点是没有统计到的。
		return max;
	}
	
	public static void main(String[] args) {
		
	}
}
