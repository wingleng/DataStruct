package leetcod._102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) {
		
	}
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> curLevel = new ArrayList<>();
            int curlevelsize = queue.size();
            for(int i=0;i<curlevelsize;i++) {
            	TreeNode cur = queue.poll();
            	if(cur.left!=null) {
            		queue.add(cur.left);
            	}
            	if(cur.right!=null) {
            		queue.add(cur.right);
            	}
            	curLevel.add(cur.val);
            }
            result.add(curLevel);
        }
        return result;
        
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
