package com.wong.graph.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.wong.graph.Edge;
import com.wong.graph.Graph;
import com.wong.graph.Node;

public class Solution {
	
	/**
	 * ����һ��ͼ
	 */
	public static Graph createGraph(Integer[][] martrix) {
		Graph graph = new Graph();
		for(int i=0;i<martrix.length;i++) {
			Integer from = martrix[i][0];
			Integer to = martrix[i][1];
			Integer weight = martrix[i][2];
			if(!graph.nodes.containsKey(from)) {
				graph.nodes.put(from, new Node(from));
			}
			if(!graph.nodes.containsKey(to)) {
				graph.nodes.put(to, new Node(to));
			}
			Node fromNode = graph.nodes.get(from);
			Node toNode = graph.nodes.get(to);
			Edge newEdge = new Edge(weight, fromNode, toNode);
			fromNode.nexts.add(toNode);
			fromNode.out++;
			toNode.in++;
			fromNode.edges.add(newEdge);
			graph.edges.add(newEdge);
		}
		return graph;
	}
	/**
	 * ͼ�Ŀ�����ȱ�����
	 * 1�����ö���ʵ��(�Լ�ʹ��һ����ϣset������ע���ֹ�ظ���ӡ
	 * 2����Դ�ڵ㿪ʼ���ΰ��տ�Ƚ����У�Ȼ�󵯳�
	 * 3��ÿ����һ���㣬�Ѹýڵ�����û�н������е��ڽӵ�������
	 * 4��ֱ�����б��
	 */
	public static void bfs(Node head) {
		if(head == null) {
			return ;
		}
		Queue<Node> queue = new LinkedList<Node>();
		HashSet<Node> hashSet = new HashSet<Node>();
		queue.add(head);
		hashSet.add(head);
		while(!queue.isEmpty()) {
			head= queue.poll();
			System.out.println(head.value);
			for(Node node:head.nexts) {
				if(!hashSet.contains(node)) {
					queue.add(node);
					hashSet.add(node);
				}
			}
		}
	}
	
	/**
	 * ͼ��������ȱ���
	 * 1����Ҫһ��ջ���Լ�һ��hashset
	 * 2��������Ƚ��ڵ����ջ��Ȼ�󵯳�
	 * 3��
	 * ������ȱ����ǷŽ�ջ֮ǰ�ͶԽڵ���д���
	 */
	public static void dfs(Node head) {
		if(head == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		HashSet<Node> hashSet = new HashSet<Node>();
		stack.push(head);
		hashSet.add(head);
		while(!stack.isEmpty()) {
			Node cur = stack.pop();
			for(Node next:head.nexts) {
				if(!hashSet.contains(next)) {
					stack.push(cur);
					stack.push(next);
					hashSet.add(next);
					System.out.println(next.value);
					break;
				}
			}
		}
	}
	
	/**
	 * ���������㷨 
	 * �������Ϊ0��������һ��ʼ�ǽ����Ϊ0�ĵ㣨���Ϊ0����Ȼ�󽫸ýڵ�ɾ���������������Ϊ0�Ľڵ㣬Ȼ��ɾ����Ȼ����ҡ�������
	 * 1��׼��һ��hashmap��keyΪnode�ڵ㣬valueΪ�����
	 * 2�� ׼��һ��queue��ֻ������Ϊ0�Ľڵ�
	 * ����
	 * 1�� ���ȱ�������ͼ����ȡ�����нڵ����ȣ��Լ����Ϊ0�Ľڵ�
	 * 2����α���queue����0�Ľڵ���뷵�ؽ���У�ͬʱ�����ýڵ������next�ڵ�����-1��-����֮��������Ϊ0�ģ�Ҳ����Ž������ 
	 */
	public static List<Node> sortedTopology(Graph graph){
		HashMap<Node, Integer> inMap = new HashMap<Node, Integer>();
		Queue<Node> zeroInQueue =new LinkedList<Node>();
		for(Node node:graph.nodes.values()) {
			inMap.put(node, node.in);
			if(node.in==0) {
				zeroInQueue.add(node);
			}
		}
		List<Node> result = new ArrayList<Node>();
		while(!zeroInQueue.isEmpty()) {
			Node curNode = zeroInQueue.poll();
			result.add(curNode);
			for(Node next:curNode.nexts) {
				inMap.put(next, inMap.get(next)-1);
				if(inMap.get(next) == 0) {
					result.add(next);
				}
			}
		}
		return result;
	}
	
	/**
	 * k�㷨����С���������ԱߵĽǶȴ���ÿ��ѡ����С�ıߣ����Ҳ����ɻ�����͵�֮�䲻����һ���ظ����� ��
	 */
	
	/**
	 * prim�㷨
	 */
	
	/**
	 * �Ͻ�˹�����㷨
	 */
	
}
