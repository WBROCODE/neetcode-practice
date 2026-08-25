class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        /**
            len: max len of word
            TC: m * n * 4 ^ len
            SC : len + m * n
        
        */
        Trie trie= new Trie();
        TrieNode root = trie.root;
        for(String word : words){
            trie.insect(word);
        }
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(i, j, visited, root, board, ans);
            }
        }
        return ans;
    }

    public void dfs(int i, int j, boolean[][] visited, TrieNode root, char[][] board, List<String> ans){
        int m = board.length, n = board[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return;
        char ch = board[i][j];
        TrieNode cur = root.children[ch];
        if(cur == null){
            return;
        }
        if(cur.isWord){
            ans.add(cur.word);
            cur.isWord = false;
        }
        
        visited[i][j] = true;
        dfs(i + 1, j, visited, cur, board, ans);
        dfs(i - 1, j, visited, cur, board, ans);
        dfs(i, j + 1, visited, cur, board, ans);
        dfs(i, j - 1, visited, cur, board, ans);
        visited[i][j] = false;
    }
}

class TrieNode{
    TrieNode[] children;
    String word;
    boolean isWord;

    public TrieNode(){
        children = new TrieNode[128];
        word = null;
        isWord = false;
    }
}

class Trie{
    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insect(String word){
        TrieNode cur = root;
        for(char ch : word.toCharArray()){
            if(cur.children[ch] == null) cur.children[ch] = new TrieNode();
            cur = cur.children[ch];
        }
        cur.isWord = true;
        cur.word = word;
    }

    public boolean search(String word){
        TrieNode cur = root;
        for(char ch : word.toCharArray()){
            if(cur.children[ch] == null) return false;
            cur = cur.children[ch];
        }
        return cur.isWord;
    }

    public boolean startWith(String word){
        TrieNode cur = root;
        for(char ch : word.toCharArray()){
            if(cur.children[ch] == null) return false;
            cur = cur.children[ch];
        }
        return true;
    }

}
