class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(char ch : word.toCharArray()){
            if(cur.children[ch] == null) cur.children[ch] = new TrieNode();
            cur = cur.children[ch];
        }
        cur.word = word;
        cur.isWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        return dfs(word, cur, 0);
    }

    public boolean dfs(String word, TrieNode cur, int start){
        if(start == word.length()) return cur.isWord;
        if(word.charAt(start) == '.'){
            for(TrieNode child : cur.children){
                if(child != null && dfs(word, child, start + 1)) return true;    
            }
            return false;
        }else{
            char curCh = word.charAt(start);
            if(cur.children[curCh] != null) return dfs(word, cur.children[curCh], start + 1);
            else return false;
        }
    }
}


class TrieNode{
    TrieNode[] children = new TrieNode[128];
    String word;
    boolean isWord;

    public TrieNode(){}
}