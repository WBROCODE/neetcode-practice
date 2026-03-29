class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(char ch : word.toCharArray()){
           if(!cur.children.containsKey(ch)) cur.children.put(ch, new TrieNode());
           cur = cur.children.get(ch);
        }
        cur.isWord = true;
        cur.word = word;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int start, TrieNode cur){

        if(word == null || word.length() == 0) return false;
        if(start == word.length()) return cur.isWord;

        if(word.charAt(start) == '.'){
            Map<Character, TrieNode> children = cur.children;
            for(TrieNode child : children.values()){
                if(child != null && dfs(word, start + 1, child)) return true;
            }
            return false; 
        }else{
            char curCh = word.charAt(start);
            TrieNode next = cur.children.get(curCh);
            return next != null && dfs(word, start + 1, next);
        }
    }
}

class TrieNode{
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord;
    String word;
}