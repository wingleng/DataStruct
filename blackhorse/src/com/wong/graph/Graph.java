package com.wong.graph;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
	public HashMap<Integer, Node> nodes;
	public HashSet<Edge> edges;
	public Graph() {
		// TODO Auto-generated constructor stub
		nodes = new HashMap<Integer, Node>();
		edges = new HashSet<Edge>();
	}
}
