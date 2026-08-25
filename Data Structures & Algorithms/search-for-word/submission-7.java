class Solution {
    boolean found;
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        found = false;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(word.charAt(0) == board[i][j]){
                    dfs(i, j, visited, board, word, 0);
                }
            }
        }
        return found;
    }

    public void dfs(int i, int j, boolean[][] visited, char[][] board, String word, int len){
        int m = board.length, n = board[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return;
        if(word.charAt(len) != board[i][j]) return;
        if(len == word.length() - 1){
            found = true;
            return;
        }
        visited[i][j] = true;
        dfs(i + 1, j, visited, board, word, len + 1);
        dfs(i - 1, j, visited, board, word, len + 1);
        dfs(i, j + 1, visited, board, word, len + 1);
        dfs(i, j - 1, visited, board, word, len + 1);
        visited[i][j] = false;
    }
}
