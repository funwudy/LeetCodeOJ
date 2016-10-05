package algorithms.a201_to_a250.a208_ImplementTrie_Medium;

/**
 * Created by 31798 on 2016/9/26.
 */
class TrieNode {
    // Initialize your data structure here.
    TrieNode[] children;
    boolean hasWord;

    public TrieNode() {
        children = new TrieNode[26];
        hasWord = false;
    }

    public void insert(String word, int idx) {
        if (idx >= word.length()) {
            hasWord = true;
            return;
        }
        char ch = word.charAt(idx);
        int i = ch - 'a';
        if (children[i] == null) {
            children[i] = new TrieNode();
        }
        children[i].insert(word, idx + 1);
    }

    public boolean search(String word, int idx) {
        if (idx >= word.length()) {
            return hasWord;
        }
        char ch = word.charAt(idx);
        int i = ch - 'a';
        if (children[i] == null) {
            return false;
        }
        return children[i].search(word, idx + 1);
    }

    public boolean startsWith(String prefix, int idx) {
        if (idx >= prefix.length()) {
            return true;
        }
        char ch = prefix.charAt(idx);
        int i = ch - 'a';
        if (children[i] == null) {
            return false;
        }
        return children[i].startsWith(prefix, idx + 1);
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null) {
            return;
        }
        root.insert(word, 0);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null) {
            return true;
        }
        return root.search(word, 0);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return true;
        }
        return root.startsWith(prefix, 0);
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("ab");
        trie.search("a");
        trie.startsWith("a");
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");