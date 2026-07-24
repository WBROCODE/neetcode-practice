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

    public boolean dfs(TrieNode root, String word, int start){
        if(start == word.length()){
            return root.isWord;
        }
        if(start > word.length()) return false;
        if(word.charAt(start) == '.'){
            TrieNode[] children = root.children;
            if(children == null) return false;
            for(TrieNode next : children){
                if(next == null) continue;
                if(dfs(next, word, start + 1)) return true;
            }
            return false;
        }else{
            TrieNode[] children = root.children;
            TrieNode child = children[word.charAt(start)];
            if(child == null) return false;
            return dfs(child, word, start + 1);
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