package com.wong.p7;

public class TrieTree {

	public static class TrieNode{
		public int pass;
		public int end;
		public TrieNode[] nexts; 
		//HashMap<Char,Node> nexts;
		//TreeMap<Char,Node> nexts;
		public TrieNode() {
			// TODO Auto-generated constructor stub
			pass = 0;
			end = 0;
			nexts = new TrieNode[26];
		}
	}
	
	public static class Trie{
		private TrieNode root;
		public Trie() {
			root = new TrieNode();
		}
		public void insert(String word) {
			if(word == null) {
				return ;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			node.pass++;
			int index = 0;
			for(int i=0;i<chs.length;i++) {
				index = chs[i]-'a'; //判断应该走哪一条路
				if(node.nexts[index]==null) {
					node.nexts[index] = new TrieNode();
				}
				node = node.nexts[index];
				node.pass++;
			}
			node.end++;
		}
		
	
	}
}
