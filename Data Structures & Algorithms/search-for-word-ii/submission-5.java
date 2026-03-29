class Solution {
    List<String> ans;
    public List<String> findWords(char[][] board, String[] words) {
        ans = new ArrayList<>();

        int m = board.length, n = board[0].length;
        Trie trie = new Trie();
        for(String word : words) trie.insert(word); 

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(board, trie.root, i, j, m, n);
            }
        }
        return ans;
    }

    public void dfs(char[][] board, TrieNode root, int i, int j, int m, int n){
        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '!') return;

        char ch = board[i][j];
        TrieNode next = root.children[ch];
        if(next == null) return;

        if(next.word != null){
            ans.add(next.word);
            next.word = null;
        }
        
        board[i][j] = '!';
        dfs(board, next, i + 1, j, m, n);
        dfs(board, next, i - 1, j, m, n);        
        dfs(board, next, i, j + 1, m, n);        
        dfs(board, next, i, j - 1, m, n);        
        board[i][j] = ch;
    }
}


class Trie{
    TrieNode root;
    public Trie(){
        this.root = new TrieNode();
    }

    public void insert(String word){
        TrieNode cur = root;

        for(char ch : word.toCharArray()){
            if(cur.children[ch] == null) cur.children[ch] = new TrieNode();
            cur = cur.children[ch];
        }
        cur.word = word;
    }

    public boolean search(String word){
        TrieNode cur = root;
        for(char ch : word.toCharArray()){
            if(cur.children[ch] == null) return false;
            cur = cur.children[ch];
        }
        return cur.word != null;
    }

    public boolean startWith(String prefix){
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
    String word;
}