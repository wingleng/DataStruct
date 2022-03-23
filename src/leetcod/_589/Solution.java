package leetcod._589;

import java.util.List;

public class Solution {
	public static void main(String[] args) {
		
	}
	public List<Integer> preOrder(Node root){
		return null;
	}
	public void trackback(Node root) {
		if(root == null) {
			return;
		}
		System.out.println();
		for(int i=0;i<root.children.size();i++) {
			trackback(root.children.get(i));
		}
	}
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};