package com.wong.p6_searchTree;
import java.util.LinkedList;
import java.util.Stack;


import com.wong.pub.TreeNode;
public class BST {
	public static void main(String[] args) {
		
	}
	/**
	 * �ж�һ�����Ƿ�������������
	 * �ⷨ3�������������ʱ�򣬼�¼ǰһ��������ֵ���ж����ֵ�Ƿ�С�ں�һ��ֵ��ͨ�����ַ�ʽ�������ж�
	 */
	public static boolean checkBST3(TreeNode head) {
		if(head!=null) {
			int preValue = Integer.MIN_VALUE;
			Double preDouble = -Double.MAX_VALUE;
			Stack<TreeNode> stack = new Stack();
			while(!stack.isEmpty() || head != null) {
				//�����е���ڵ���ջ
				if(head!=null) {
					stack.push(head);
					head = head.left;
				}
				else {
					head = stack.pop();
					//����
					if(head.value<=preValue) {
						return false;
					}
					else {
						preValue = head.value;
					}
					
					head = head.righ;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * �ж�һ�����Ƿ���һ���������������ⷨ����������
	 */
	public static int preValue = Integer.MIN_VALUE;
	public static boolean checkBST(TreeNode head) {
		if(head == null) {
			return true;
		}
		boolean isLeftBst = checkBST(head.left);
		if(!isLeftBst) {
			return false;
		}
		if(head.value <= preValue) {
			return false;
		}else {
			preValue = head.value;
		}
		return checkBST(head.righ);
	}
	
	/**
	 * �ж�һ�Ŷ������Ƿ���һ����ȫ������,���ѣ����ǽ�������������ȱ�����Ȼ�����ÿ���ڵ��жϣ��ж��Ƿ������������
	 * 1������ڵ��Ƿ����Һ��Ӷ�û������ 2������ڵ��Ƿ���Ҷ�ӽڵ㣬�ǵ�һ��Ҷ�ӽڵ�֮��Ľڵ㣿
	 */
	public static boolean isCBT(TreeNode head) {
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		boolean leaf = false;//�Ƿ������˵�һ��Ҷ�ӽڵ�ı��
		TreeNode l = null;
		TreeNode r = null;
		queue.add(head);
		while(!queue.isEmpty()) {
			head = queue.poll();
			l = head.left;
			r = head.righ;
			
			if(
					(leaf&&(l!=null||r!=null))
					||
					(l == null && r!=null)
					) {
				return false;
			}
			if(l!=null) {
				queue.add(l);
			}
			if(r!=null) {
				queue.add(r);
			}
			if(l == null || r==null) {
				leaf = true;
			}
		}
		return true;
	}
}
