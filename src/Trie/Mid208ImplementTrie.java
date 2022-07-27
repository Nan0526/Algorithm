package Trie;

/*
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
Implement the Trie class:
Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

Example 1:
Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True

 */

public class Mid208ImplementTrie {

	 TrieNode root;
	    public void Trie() {
	        root = new TrieNode(' ');
	    }
	    
	    public void insert(String word) {
	        TrieNode cur = root;
	        for(int i = 0; i < word.length(); i++) {
	            char c = word.charAt(i);
	            if(cur.children[c - 'a'] == null) {
	                cur.children[c - 'a'] = new TrieNode(c);
	            }
	            cur = cur.children[c - 'a'];
	        }
	        cur.isWord = true;
	    }
	    
	    public boolean search(String word) {
	        TrieNode cur = root;
	        for(int i = 0; i < word.length(); i++) {
	            char c = word.charAt(i);
	            if(cur.children[c - 'a'] == null) {
	                return false;
	            }else {
	                cur = cur.children[c - 'a'];
	            }
	        }
	        return cur.isWord;
	    }
	    
	    public boolean startsWith(String prefix) {
	        TrieNode cur = root;
	        for(int i = 0; i < prefix.length(); i++) {
	            char c = prefix.charAt(i);
	            if(cur.children[c - 'a'] == null) {
	                return false;
	            }else {
	                cur = cur.children[c - 'a'];
	            }
	        }
	        return true;
	    }
}

class TrieNode{
    char val;
    TrieNode[] children;
    boolean isWord;
    
    public TrieNode(char val){
        this.val = val;
        children = new TrieNode[26];
        isWord = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
