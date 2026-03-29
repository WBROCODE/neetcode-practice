class Solution {
    Set<String> ans;
    StringBuilder sb;
    public List<String> findWords(char[][] board, String[] words) {
        ans = new HashSet<>();
        sb = new StringBuilder();

        int m = board.length, n = board[0].length;
        Trie trie = new Trie();
        for(String word : words) trie.insert(word); 

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                String start = board[i][j] + "";
                if(trie.startWith(start)){
                    dfs(board, trie, i, j, m, n);
                }
            }
        }
        return new ArrayList<>(ans);
    }

    public void dfs(char[][] board, Trie trie, int i, int j, int m, int n){
        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '!') return;
           
        char ch = board[i][j];
        sb.append(ch);

        if(!trie.startWith(sb.toString())){
            sb.deleteCharAt(sb.length() - 1);
            return;
        };

        if(trie.search(sb.toString())){
            ans.add(sb.toString());
        }

        board[i][j] = '!';
        dfs(board, trie, i + 1, j, m, n);
        dfs(board, trie, i - 1, j, m, n);        
        dfs(board, trie, i, j + 1, m, n);        
        dfs(board, trie, i, j - 1, m, n);        
        board[i][j] = ch;
        sb.deleteCharAt(sb.length() - 1);
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
        cur.isWord = true;
    }

    public boolean search(String word){
        TrieNode cur = root;
        for(char ch : word.toCharArray()){
            if(cur.children[ch] == null) return false;
            cur = cur.children[ch];
        }
        return cur.isWord;
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
    boolean isWord;
}