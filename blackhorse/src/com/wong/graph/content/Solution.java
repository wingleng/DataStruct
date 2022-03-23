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
	 * 创建一个图
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
	 * 图的宽度优先遍历。
	 * 1，利用队列实现(以及使用一个哈希set，用来注册防止重复打印
	 * 2，从源节点开始依次按照宽度进队列，然后弹出
	 * 3，每弹出一个点，把该节点所有没有进过队列的邻接点放入队列
	 * 4，直到队列变空
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
	 * 图的深度优先遍历
	 * 1，需要一个栈，以及一个hashset
	 * 2，按照深度将节点放入栈，然后弹出
	 * 3，
	 * 深度优先遍历是放进栈之前就对节点进行处理
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
	 * 拓扑排序算法 
	 * 按照入度为0进行排序，一开始是将入度为0的点（入度为0），然后将该节点删掉，继续查找入度为0的节点，然后删除，然后查找。。。。
	 * 1，准备一个hashmap，key为node节点，value为其入度
	 * 2， 准备一个queue，只存放入度为0的节点
	 * 处理：
	 * 1， 首先遍历整个图，获取到所有节点地入度，以及入度为0的节点
	 * 2，其次遍历queue，将0的节点放入返回结果中，同时，将该节点的所有next节点的入度-1，-完了之后，如果入度为0的，也将其放进结果中 
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
	 * k算法，最小生成树，以边的角度处理，每次选择最小的边，并且不构成环（点和点之间不构成一个重复集合 ）
	 */
	
	/**
	 * prim算法
	 */
	
	/**
	 * 迪杰斯特拉算法
	 */
	
}
