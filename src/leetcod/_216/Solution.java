package leetcod._216;

import java.util.*;
/**
 * 组合总和Ⅲ
 * 一道回溯算法题目
 * @author WONG
 *
 */
public class Solution {
	public static void main(String[] args) {
		int k=3;
		int n=9;
		Solution t = new Solution();
		List<List<Integer>> rst = t.combinationSum3(k, n);
//		for (List<Integer> list : rst) {
//			System.out.println(list.get(0)+list.get(1)+list.get(2));
//		}
		System.out.println(rst);
		
	}
	public List<List<Integer>> combinationSum3(int k, int n) {
        //拆分集合类题目，使用回溯算法。
        //由题意可得，该回溯算法的深度为k层，初始集合应该为1...9，终止条件为path的值==n
		//因为单个结果的数组的长度为k，所以深度为k，就是说，这个需要递归进入k次才能完成一个数组？
		trackback(k, n,0, 1);
		return result;
    }
	
    List<List<Integer>> result = new ArrayList<>();//结果
    LinkedList<Integer> path = new LinkedList<>();//单个列表的值
    public void trackback(int k,int n,int sum,int startIndex){//k，n，sum为path中的路径之和（免得使用List计算，容易数组越界）,startIndex为每层中集合开始的位置
    	//终止条件
    	if(path.size()==k) {
    		if(sum == n) {//如果路径总和符合条件就收集起来
    			result.add(new ArrayList<>(path));//这里是java版代码的巨坑，path如果不转化类型的话，结果是没有添加到result中的
    		}
    		return;//如果路径到达最大深度，但是没有符合条件，直接返回。
    	}
    	
        //单层逻辑：
        for(int i=startIndex;i<=9;i++) {
        	sum = sum+i;//记录当前节点的和
        	path.add(i);//记录节点
        	
        	trackback(k, n,sum, i+1);
        	sum = sum-i;//删除记录。
        	path.removeLast();//释放节点
        }
    }
}
