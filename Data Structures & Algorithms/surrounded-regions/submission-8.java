class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O') dfs(i, 0, m, n, board);
            if(board[i][n - 1] == 'O') dfs(i, n - 1, m, n, board);
        }

        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O') dfs(0, j, m, n, board);
            if(board[m - 1][j] == 'O') dfs(m - 1, j, m, n, board);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '#'){
                    board[i][j] = 'O';                
                }
            }
        }

    }

    public void dfs(int i, int j, int m, int n, char[][] board){
        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') return;
        if(board[i][j] == 'O') board[i][j] = '#';

        dfs(i + 1, j, m, n, board);
        dfs(i - 1, j, m, n, board);
        dfs(i, j + 1, m, n, board);
        dfs(i, j - 1, m, n, board);
    }
}
