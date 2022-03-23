package com.wong.p5_linklist;


public class LinkList {

	//两个有环链表，返回第一个相交节点，如果不相交，则返回null
	public static Node bothLoop(Node head1,Node loop1,Node head2,Node loop2) {
		Node cur1 = null;
		Node cur2 = null;
		//情况二，按照相交链表的方法处理
		if(loop1 == loop2) {
			cur1 = head1;
			cur2 = head2;
			int n=0;
			while(cur1 !=loop1) {
				n++;
				cur1 = cur1.next;
			}
			while(cur2 !=loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n>0? head1:head2;
			cur2 = cur1==head1?head2:head1;
			n = Math.abs(n);
			while(n!=0) {
				n--;
				cur1 = cur1.next;
			}
			while(cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		}
		//不是情况二，那就进入到环中，继续前进
		else {
			cur1 = loop1.next;
			while(cur1 !=loop1) {
				//如果遇到了第二个相交节点，那么说明是情况三
				if(cur1 == loop2) {
					return loop1;
				}
				cur1 = cur1.next;
			}
			//在环中没有找到第二个相交节点，说明是情况一，直接返回null
			return null;
		}

	}
}

class Node<V>{
	V value;
	Node next;
}