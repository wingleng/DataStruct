package leetcod._208;

/**
 * 208.实现前缀树
 * @author WONG
 *
 */
public class Solution {
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple"); 
		System.out.println(trie.search("apple"));
		System.out.println(trie.search("app"));
		System.out.println(trie.startsWith("app"));
	}
}
class Trie {
	
	boolean end_flag;
	Trie[] nexts;
	
    public Trie() {
    	end_flag = false;
    	nexts = new Trie[26];
    }
    
    //插入一条字符串，直接一条路走到黑？
    public void insert(String word) {
    	Trie node = this;
    	for(int i=0;i<word.length();i++) {
    		int cha = word.charAt(i) - 'a';
    		if(node.nexts[cha] == null) {
    			node.nexts[cha] = new Trie();
    		}
    		node = node.nexts[cha];
    	}
    	node.end_flag = true;
    }
    
    //search方法是查找这个前缀树上面是否有这个单词
    public boolean search(String word) {
    	Trie node = searchPrefix(word);
    	return node !=null && node.end_flag;
    }
    
    //这个方法是查看是否有字符串是以这个前缀开始的。
    public boolean startsWith(String prefix) {
    	return searchPrefix(prefix) !=null;

    }
    
    private Trie searchPrefix(String prefix) {
    	Trie node = this;
    	for(int i=0;i<prefix.length();i++) {
    		int index = prefix.charAt(i)-'a';
    		if(node.nexts[index] == null) {
    			return null;
    		}
    		node = node.nexts[index];
    	}
    	return node;
    }
    

}