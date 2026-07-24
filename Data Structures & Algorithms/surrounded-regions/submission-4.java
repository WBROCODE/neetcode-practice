class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m ; i++){
            dfs(i, 0, m, n, board);
            dfs(i, n - 1, m, n, board);
        }

        for(int i = 0; i < n ; i++){
            dfs(0, i, m, n, board);
            dfs(m - 1, i, m, n, board);
        }

        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                
            }
        }

        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++){
                if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }


    public void dfs(int i, int j, int m, int n, char[][] board){
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] == 'X' || board[i][j] == '#') return;

        board[i][j] = '#';
        dfs(i + 1, j, m, n, board);
        dfs(i - 1, j, m, n, board);
        dfs(i, j + 1, m, n, board);
        dfs(i, j - 1, m, n, board);
    }
}
