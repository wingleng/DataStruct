package leetcod._606;

public class Solution {
	public static void main(String[] args) {
		TreeNode node4 = new TreeNode(4);
		TreeNode node2 = new TreeNode(2,node4,null);
		TreeNode node3 = new TreeNode(3);
		TreeNode node1 = new TreeNode(1,node2,node3);
		String rst = tree2str(node1);
		System.out.println(rst);
	}
	 public static String tree2str(TreeNode root) {
		 if(root==null) {
			 return "";
		 }
		 if(root.left==null && root.right==null) {
			return Integer.toString(root.val);
		 }
		 if(root.right == null) {
			 return new StringBuffer().append(root.val).append("(").append(tree2str(root.left)).append(")").toString();
		 }
		 return new StringBuffer().append(root.val).append("(").append(tree2str(root.left)).append(")(").append(tree2str(root.right)).append(")").toString();

	 }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }