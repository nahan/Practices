package facebook.medium;

// https://leetcode.com/problems/add-and-search-word-data-structure-design/

// 211

public class AddAndSearchWordDataStructure {

    private Trie root = new Trie();

    // Adds a word into the data structure.
    public void addWord(String word) {
        root.add(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        return search(root, word, 0);
    }
    
    private boolean search(Trie node, String s, int index) {
        if (node == null) {
            return false;
        }
        if (index == s.length()) {
            return node.isLeaf;
        }
        char c = s.charAt(index);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (search(node.children[i], s, index + 1)) {
                    return true;
                }
            }
            return false;
        }
        if (node.children[c - 'a'] == null) {
            return false;
        } else {
            return search(node.children[c - 'a'], s, index + 1);
        }
    }
    
    static class Trie {
        boolean isLeaf = false;
        Trie[] children = new Trie[26];
        void add(String s) {
            Trie node = this;
            for (int i = 0; i < s.length(); i++) {
                if (node.children[s.charAt(i) - 'a'] == null) {
                    node.children[s.charAt(i) - 'a'] = new Trie();
                }
                node = node.children[s.charAt(i) - 'a'];
            }
            node.isLeaf = true;
        }
    }
}
