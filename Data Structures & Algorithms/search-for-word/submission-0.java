class Solution {
    boolean found = false;
    boolean[][] visited; 

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)) dfs(board, word, i, j, 0);          
            }
        }
        return found;
    }

    public void dfs(char[][] board, String word, int i, int j, int len){
        int m = board.length, n = board[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j] 
        || found || word.charAt(len) != board[i][j]) return;

        if(len + 1 == word.length() ){
            found = true;
            return;
        }
        
        visited[i][j] = true;
        dfs(board, word, i + 1, j, len + 1);
        dfs(board, word, i - 1, j, len + 1);
        dfs(board, word, i, j + 1, len + 1);
        dfs(board, word, i, j - 1, len + 1);
        visited[i][j] = false;
    }

}
