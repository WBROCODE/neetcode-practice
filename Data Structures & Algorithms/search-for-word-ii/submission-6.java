class Solution {
    List<String> ans;
    public List<String> findWords(char[][] board, String[] words) {
        ans = new ArrayList<>();
        int m = board.length, n = board[0].length;
        Trie trie = new Trie();
        for(String word : words){
            trie.insect(word);
        }
        TrieNode root = trie.root;
        for(int i = 0;i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(i, j, m, n, root, board);
            }
        }
        return ans;
    }

    public void dfs(int i, int j, int m, int n, TrieNode root, char[][] board){
        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '!') return;
        char ch = board[i][j];
        TrieNode next = root.children[ch];

        if(next == null) return;
        if(next.isWord){
            ans.add(next.word);
            next.isWord = false;
            next.word = null;
        }

        board[i][j] = '!';
        dfs(i + 1, j, m, n, next, board);
        dfs(i - 1, j, m, n, next, board);
        dfs(i, j + 1, m, n, next, board);
        dfs(i, j - 1, m, n, next, board);
        board[i][j] = ch;
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
}

class TrieNode{
    TrieNode[] children = new TrieNode[128];
    String word;
    boolean isWord;
}
