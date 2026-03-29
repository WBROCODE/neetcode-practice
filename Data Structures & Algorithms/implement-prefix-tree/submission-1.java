class PrefixTree {
    TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(char ch : word.toCharArray()){
            if(cur.children[ch] == null) cur.children[ch] = new TrieNode();
            cur = cur.children[ch];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for(char ch : word.toCharArray()){
            if(cur.children[ch] == null) return false;
            cur = cur.children[ch];
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char ch : prefix.toCharArray()){
            if(cur.children[ch] == null) return false;
            cur = cur.children[ch];
        }
        return true;
    }
}

class TrieNode{
    TrieNode[] children = new TrieNode[128];
    boolean isWord;
    public TrieNode(){}
}
