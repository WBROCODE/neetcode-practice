class Solution {
    List<List<String>> ans = new ArrayList<>();
    char[][] board;
    public List<List<String>> solveNQueens(int n) {
        if(n == 0) return ans;
        // place in row
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
            if(isValid(board, start, i, n)){
                board[start][i] = 'Q';
                backTrack(board, start + 1, n);
                board[start][i] = '.';
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

        for(int i = x - 1, j = y + 1; i >= 0 && j < n; i--, j++){
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
    
}
