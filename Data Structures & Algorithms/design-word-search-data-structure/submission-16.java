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
        cur.word= word;
        cur.isWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        return dfs(word, 0, cur);
    }

    public boolean dfs(String word, int start, TrieNode cur){
        if(cur == null) return false;
        if(start == word.length()){
            return cur.isWord;
        }

        char ch = word.charAt(start);
        if(ch == '.'){
            for(TrieNode child : cur.children){
                if(child == null) continue;
                if(dfs(word, start + 1, child)) return true;
            }
            return false;
        }
        return dfs(word, start + 1, cur.children[ch]);
    }

}

class TrieNode{
    TrieNode[] children;
    boolean isWord;
    String word;

    public TrieNode(){
        isWord = false;
        children = new TrieNode[128];
        word = null;
    }


}
