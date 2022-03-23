package com.wong.graph;

import java.util.ArrayList;

/**
 * Í¼µÄ½Úµã
 * @author BENWONG
 *
 */
public class Node {
	public int value;
	public int in;
	public int out;
	public ArrayList<Node> nexts;
	public ArrayList<Edge> edges;
	public Node(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
		in = 0;
		out = 0;
		nexts = new ArrayList<>();
		edges = new ArrayList<>();
	}
}
