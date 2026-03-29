class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;

        int m = board.length, n = board[0].length;

        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O') dfs(i, 0, board, m, n);
            if(board[i][n - 1] == 'O') dfs(i, n - 1, board, m, n);
            
        }

        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O') dfs(0, j, board, m, n);
            if(board[m - 1][j] == 'O') dfs(m - 1, j, board, m, n);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O') board[i][j] ='X';
                if(board[i][j] == '#') board[i][j] ='O';
            }
        }
    }

    public void dfs(int i, int j, char[][] board, int m, int n){
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] == 'X' 
        || board[i][j] == '#'
        ) return;
        board[i][j] = '#';
        dfs(i + 1, j, board, m, n);
        dfs(i - 1, j, board, m, n);
        dfs(i, j - 1, board, m, n);
        dfs(i, j + 1, board, m, n);
    }
}
