package com.wong.p5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		
	}
	/**
	 * 二叉树的前序遍历
	 * @param head
	 */
	public static void preOrderUnRecur(Node head) {
		System.out.println("pre-order:");
		if(head!=null) {
			Stack<Node> stack = new Stack();
			stack.add(head);
			while(!stack.empty()) {
				stack.pop();
				System.out.println(head.value+" ");
				if(head.right != null) {
					stack.push(head.right);
				}
				if(head.left != null) {
					stack.push(head.left);
				}
			}
		}
		System.out.println();
	}
	/**
	 * 二叉树的中旭遍历
	 */
	public static void inOrder(Node head) {
		System.out.println("in-order");
		Stack<Node> stack = new Stack<Node>();
		while(head!=null || !stack.empty()) {
			//直接将整个树的左边界全部进栈
			if(head != null) {
				stack.push(head);
				head = head.left;
			}
			//左边界全部进栈之后，head会为空，然后就开始弹出。处理每一个弹出的节点。
			else {
				head = stack.pop();//将指针移动到弹出节点
				System.out.println(head.value + " ");//处理弹出的节点
				head = head.right;//然后到右子树上面去
			}
		}
	}
	
	/**
	 * 二叉树的后序遍历
	 * @param head
	 */
	public static void posOrder(Node head) {
		System.out.println("pos-order: ");
		if(head != null) {
			Stack<Node> s1 = new Stack<Node>();
			Stack<Node> s2 = new Stack<Node>();
			s1.push(head);
		
		while(head!=null) {
			head = s1.pop(); //操作栈弹出一个
			s2.push(head); //然后将其压入收集栈
			if(head.left != null) {
				s1.push(head.left);
			}
			if(head.right != null) {
				s1.push(head.right);
			}
		}
		
		//将收集栈的所有节点弹出，结果即为二叉树的后续遍历
		while(!s2.empty()) {
			System.out.println(s2.pop().value + " ");
		}
		}
	}
	
	
	/**
	 * 二叉树的宽度优先遍历
	 */
	public static void wid(Node head	) {
		if(head == null) {
			return ;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(head);
		while(!queue.isEmpty()) {
			Node curNode = queue.poll();//弹出一个节点，然后将其左右孩子进队
			System.out.println(curNode.value + " ");
			if(curNode.left!=null) {
				queue.add(curNode.left);
			}
			if(curNode.right!=null) {
				queue.add(curNode.right);
			}
		}
	}
	
	/**
	 * 计算二叉树的最大宽度
	 * 思路：同样是使用一个哈希表来记录层数。
	 */
	public static int getMaxWidth(Node head) {
		if(head == null) {
			return 0;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(head);
		HashMap<Node, Integer> levelMap = new HashMap<Node, Integer>();
		levelMap.put(head, 1);
		int curLevel = 1;
		int curLevelNodes = 0;
		int max = Integer.MIN_VALUE;
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			int curNodeLevel = levelMap.get(cur);
			
			//判断当前队列中弹出的节点是否是在当前层中，如果是，就说明当前层中还有节点
			if(curNodeLevel == curLevel) {
				curLevelNodes++;
			}
			else {//如果不在当前层中，就需要结算当前层中，最大的宽度是多少
				max = Math.max(max, curLevelNodes);
				
				curLevel++;//跳到下一层级中，并且将当前层节点数量重置
				curLevelNodes = 1;
			}
			
			//将其左右孩子节点入队，并且记录其所在层数
			if(cur.left!=null) {
				levelMap.put(cur.left, curNodeLevel+1);
				queue.add(cur.left);
			}
			if(cur.right!=null) {
				levelMap.put(cur.left, curNodeLevel+1);
				queue.add(cur.right);
			}
		}
		
		return max;
	}
	
}

class Node<V>{
	V value;
	Node left;
	Node right;
	public Node() {
		// TODO Auto-generated constructor stub
	}
}