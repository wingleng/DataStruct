package leetcod._216;

import java.util.*;
/**
 * ����ܺ͢�
 * һ�������㷨��Ŀ
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
        //��ּ�������Ŀ��ʹ�û����㷨��
        //������ɵã��û����㷨�����Ϊk�㣬��ʼ����Ӧ��Ϊ1...9����ֹ����Ϊpath��ֵ==n
		//��Ϊ�������������ĳ���Ϊk���������Ϊk������˵�������Ҫ�ݹ����k�β������һ�����飿
		trackback(k, n,0, 1);
		return result;
    }
	
    List<List<Integer>> result = new ArrayList<>();//���
    LinkedList<Integer> path = new LinkedList<>();//�����б��ֵ
    public void trackback(int k,int n,int sum,int startIndex){//k��n��sumΪpath�е�·��֮�ͣ����ʹ��List���㣬��������Խ�磩,startIndexΪÿ���м��Ͽ�ʼ��λ��
    	//��ֹ����
    	if(path.size()==k) {
    		if(sum == n) {//���·���ܺͷ����������ռ�����
    			result.add(new ArrayList<>(path));//������java�����ľ޿ӣ�path�����ת�����͵Ļ��������û����ӵ�result�е�
    		}
    		return;//���·�����������ȣ�����û�з���������ֱ�ӷ��ء�
    	}
    	
        //�����߼���
        for(int i=startIndex;i<=9;i++) {
        	sum = sum+i;//��¼��ǰ�ڵ�ĺ�
        	path.add(i);//��¼�ڵ�
        	
        	trackback(k, n,sum, i+1);
        	sum = sum-i;//ɾ����¼��
        	path.removeLast();//�ͷŽڵ�
        }
    }
}
