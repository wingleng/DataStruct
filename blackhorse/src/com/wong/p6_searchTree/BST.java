package com.wong.p6_searchTree;
import java.util.LinkedList;
import java.util.Stack;


import com.wong.pub.TreeNode;
public class BST {
	public static void main(String[] args) {
		
	}
	/**
	 * 判断一颗树是否是搜索二叉树
	 * 解法3，在中序遍历的时候，记录前一个遍历的值，判断这个值是否小于后一个值，通过这种方式来进行判断
	 */
	public static boolean checkBST3(TreeNode head) {
		if(head!=null) {
			int preValue = Integer.MIN_VALUE;
			Double preDouble = -Double.MAX_VALUE;
			Stack<TreeNode> stack = new Stack();
			while(!stack.isEmpty() || head != null) {
				//将所有的左节点入栈
				if(head!=null) {
					stack.push(head);
					head = head.left;
				}
				else {
					head = stack.pop();
					//处理
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
	 * 判断一棵树是否是一颗搜索二叉树，解法二，遍历法
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
	 * 判断一颗二叉树是否是一颗完全二叉树,不难，就是将二叉树宽度优先遍历，然后就是每个节点判断，判断是否符合两个条件
	 * 1，这个节点是否有右孩子而没有左孩子 2，这个节点是否是叶子节点，是第一个叶子节点之后的节点？
	 */
	public static boolean isCBT(TreeNode head) {
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		boolean leaf = false;//是否遇到了第一个叶子节点的标记
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
