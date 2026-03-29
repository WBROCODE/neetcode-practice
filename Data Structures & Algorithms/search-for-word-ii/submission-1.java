class Solution {
    List<String> ans;

    int[][] dirs = new int[][]{
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1},
    };

    public List<String> findWords(char[][] board, String[] words) {
        ans = new ArrayList<>();
        TrieNode root = buildTrie(words);
        int m = board.length, n = board[0].length;
        boolean[] starts = new boolean[26];
        for(int i = 0; i < 26; i++){
            if(root.children[i] != null) starts[i] = true;
        }


        for(int i = 0;  i < m; i++){
            for(int j = 0; j < n; j++){
                if(starts[board[i][j] - 'a']) dfs(i, j, root, board);
            }
        }
        
        return ans;
    }

    public void dfs(int x, int y, TrieNode cur, char[][] board){
        int m = board.length, n = board[0].length;
        if(x < 0 || x >= m || y < 0 || y >= n) return;
        
        int index = board[x][y] - 'a';
        char curCh = board[x][y];
        if(curCh == '*') return;
        TrieNode next = cur.children[index];
        if(next == null) return;
        if(next.word != null){
            ans.add(next.word);
            next.word = null;
        }

        board[x][y] = '*';
        for(int[] dir : dirs){
            int newX = dir[0] + x;
            int newY = dir[1] + y;
            dfs(newX, newY, next, board);
        }
        board[x][y] = curCh;

        if(isLeaf(next)){
            next.children[index] = null;
        }
    }

    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode cur = root;
            for(char ch : word.toCharArray()){
                int index = ch - 'a';
                if(cur.children[index] == null){
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            cur.word= word;
        }

        return root;
    }

    public boolean isLeaf(TrieNode cur){
        if(cur.word != null) return false;
        for (TrieNode ch : cur.children) if (ch != null) return false;
        return true;
    }
}

class TrieNode{
    String word;
    TrieNode[] children = new TrieNode[26];

}
