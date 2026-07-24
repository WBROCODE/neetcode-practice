class Solution {
    List<List<String>> ans;
    char[][] board;

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        board = new char[n][n];
        for(int i =0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        backTrack(0, n);

        return ans;
    }

    public void backTrack(int start, int n){
        if(start == n){
            // add
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                temp.add(new String(board[i]));
            }
            ans.add(new ArrayList<>(temp));
            return ;
        }

        for(int i = 0; i < n; i++){
            if(valid(start, i, n)){
                board[start][i] = 'Q'; 
                backTrack(start + 1, n);
                board[start][i] = '.'; 
            }
        }
    }

    public boolean valid(int x, int y, int n){
        for(int i = 0; i < n; i++){
            if(board[x][i] == 'Q') return false;
        }
        for(int i = 0; i < n; i++){
            if(board[i][y] == 'Q') return false;
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
