class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
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

    public boolean dfs(String word, int index, TrieNode cur) {
        if(cur == null) return false;
        if(word.length() == index) return cur.isEnd;

        char ch = word.charAt(index);
        if(ch == '.'){
            for(TrieNode child : cur.children){
                if(child != null && dfs(word, index + 1, child)) return true;
            }
            return false;
        }else{
            TrieNode next = cur.children[ch - 'a'];
            return dfs(word, index + 1, next);
        }
    }

    
    public boolean search(String word) {
        return dfs(word,0,  root);
    }
}

class TrieNode{
    boolean isEnd;
    TrieNode[] children = new TrieNode[26];

    public TrieNode(){
    }
}