class Solution {
    List<List<String>> ans = new ArrayList<>();
    char[][] board;
    public List<List<String>> solveNQueens(int n) {
        // place in col
        if(n == 0) return ans;
        board = new char[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        backTrack(board, 0, n);
        return ans;
    }

    public void backTrack(char[][] board, int start, int n){
        if(start == n){
            List<String> copy = new ArrayList<>();
            for(int i = 0; i < n; i++){
                copy.add(new String(board[i]));
            }
            ans.add(new ArrayList<>(copy));
            return;
        }

      
        for(int i = 0; i < n; i++){
            if(isValid(board, i, start, n)){
                board[i][start] = 'Q';
                backTrack(board, start + 1, n);
                board[i][start] = '.';
            }
        }
        
    }


    public boolean isValid(char[][] board, int x, int y, int n){
        for(int i = x - 1; i >= 0; i--){
            if(board[i][y] == 'Q') return false;
        }

        for(int j = y - 1; j >= 0; j--){
            if(board[x][j] == 'Q') return false;
        }

        for(int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q') return false;
        }

        for(int i = x + 1, j = y - 1; i < n && j >= 0; i++, j--){
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
}
