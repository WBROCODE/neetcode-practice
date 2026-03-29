class PrefixTree {
    TrieNode root;
    public PrefixTree() {
        this.root = new TrieNode();    
    }

    public void insert(String word) {
        TrieNode cur = this.root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            TrieNode[] children = cur.children;
            if(children[index] == null){
                children[index] = new TrieNode();
            }
            cur = children[index];
        }
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = this.root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            TrieNode[] children = cur.children;
            if(children[index] == null){
                return false;
            }
            cur = children[index];
        }
        return cur.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = this.root;
        for(char ch : prefix.toCharArray()){
            int index = ch - 'a';
            TrieNode[] children = cur.children;
            if(children[index] == null){
                return false;
            }
            cur = children[index];
        }

        return true;
    }
}

class TrieNode{

    boolean isEnd;
    TrieNode[] children = new TrieNode[26];

}
