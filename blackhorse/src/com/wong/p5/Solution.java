package com.wong.p5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		
	}
	/**
	 * ��������ǰ�����
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
	 * ���������������
	 */
	public static void inOrder(Node head) {
		System.out.println("in-order");
		Stack<Node> stack = new Stack<Node>();
		while(head!=null || !stack.empty()) {
			//ֱ�ӽ�����������߽�ȫ����ջ
			if(head != null) {
				stack.push(head);
				head = head.left;
			}
			//��߽�ȫ����ջ֮��head��Ϊ�գ�Ȼ��Ϳ�ʼ����������ÿһ�������Ľڵ㡣
			else {
				head = stack.pop();//��ָ���ƶ��������ڵ�
				System.out.println(head.value + " ");//�������Ľڵ�
				head = head.right;//Ȼ������������ȥ
			}
		}
	}
	
	/**
	 * �������ĺ������
	 * @param head
	 */
	public static void posOrder(Node head) {
		System.out.println("pos-order: ");
		if(head != null) {
			Stack<Node> s1 = new Stack<Node>();
			Stack<Node> s2 = new Stack<Node>();
			s1.push(head);
		
		while(head!=null) {
			head = s1.pop(); //����ջ����һ��
			s2.push(head); //Ȼ����ѹ���ռ�ջ
			if(head.left != null) {
				s1.push(head.left);
			}
			if(head.right != null) {
				s1.push(head.right);
			}
		}
		
		//���ռ�ջ�����нڵ㵯���������Ϊ�������ĺ�������
		while(!s2.empty()) {
			System.out.println(s2.pop().value + " ");
		}
		}
	}
	
	
	/**
	 * �������Ŀ�����ȱ���
	 */
	public static void wid(Node head	) {
		if(head == null) {
			return ;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(head);
		while(!queue.isEmpty()) {
			Node curNode = queue.poll();//����һ���ڵ㣬Ȼ�������Һ��ӽ���
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
	 * ����������������
	 * ˼·��ͬ����ʹ��һ����ϣ������¼������
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
			
			//�жϵ�ǰ�����е����Ľڵ��Ƿ����ڵ�ǰ���У�����ǣ���˵����ǰ���л��нڵ�
			if(curNodeLevel == curLevel) {
				curLevelNodes++;
			}
			else {//������ڵ�ǰ���У�����Ҫ���㵱ǰ���У����Ŀ���Ƕ���
				max = Math.max(max, curLevelNodes);
				
				curLevel++;//������һ�㼶�У����ҽ���ǰ��ڵ���������
				curLevelNodes = 1;
			}
			
			//�������Һ��ӽڵ���ӣ����Ҽ�¼�����ڲ���
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