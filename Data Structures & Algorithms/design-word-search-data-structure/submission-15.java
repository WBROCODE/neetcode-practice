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
        cur.isWord = true;
        cur.word = word;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    public boolean dfs(TrieNode cur, String word, int start){
        if(start == word.length()){
            return cur.isWord;
        }
        if(start > word.length()) return false;
        if(word.charAt(start) == '.'){
            
            for(TrieNode child : cur.children){
                if(child == null) continue;
                if(dfs(child, word, start + 1)) return true;;
            }
            return false;
        }else{
            char ch = word.charAt(start);
            if(cur.children[ch] == null) return false;
            cur = cur.children[ch];
            return dfs(cur, word, start + 1);
        }
    }
}

class TrieNode{
    TrieNode[] children;
    boolean isWord;
    String word;

    public TrieNode(){
        children = new TrieNode[128];
        isWord = false;
        word = null;
    }
}
