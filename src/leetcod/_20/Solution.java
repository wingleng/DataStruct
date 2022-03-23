package leetcod._20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		String str = "()[]{}";
		System.out.println(isValid(str));
	}
	public static boolean isValid(String str) {
		Stack<Character> stack = new Stack<>();
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		for (Character c : str.toCharArray()) {
			if(map.containsKey(c)) {//”ˆµΩ¡À”“¿®∫≈
				if(!stack.isEmpty() && !(map.get(c).equals(stack.peek()) )) {
					return false;
				}
				stack.pop();
			}else {
				stack.push(c);
			}
		}
		if(!stack.isEmpty())return false;
		return true;
	}
}
