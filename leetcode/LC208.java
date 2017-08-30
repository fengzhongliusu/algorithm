package leetcode;

/**
 * 前缀树(字典树)的实现，插入，查找单词，查找前缀.
 */
public class LC208 {
    Node root;
    static class Node {
        boolean end;                           /// 标记该节点是否是某个单词的结束节点.
        Node[] child = new Node[26];           /// 可能的节点值(26个小写字母)
    }
    /** Initialize your data structure here. */
    public LC208() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int idx;
        Node tmp = root;
        for(int i=0; i<word.length(); i++) {
            idx = word.charAt(i) - 'a';
            if(tmp.child[idx] == null) tmp.child[idx] = new Node();
            tmp = tmp.child[idx];
        }
        tmp.end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node tmp = root;
        int idx;
        for(int i=0; i<word.length(); i++) {
            idx = word.charAt(i) - 'a';
            if(tmp.child[idx] == null) return false;
            tmp = tmp.child[idx];
        }
        return tmp.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        Node tmp = root;
        int idx;
        for(int i=0; i<word.length(); i++) {
            idx = word.charAt(i) - 'a';
            if(tmp.child[idx] == null) return false;
            tmp = tmp.child[idx];
        }
        return true;
    }
}
