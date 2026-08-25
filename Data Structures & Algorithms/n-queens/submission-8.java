class Solution {
    List<List<String>> ans = new ArrayList<>();
    char[][] board;
    
    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        bT(n, 0);
        return ans;
    }

    public void bT(int n, int start){
        if(start == n){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                temp.add(new String(board[i]));
            }
            ans.add(new ArrayList<>(temp));
            return;
        }else{
            for(int j = 0; j < n; j++){
                if(check(start, j)){
                    board[start][j] = 'Q';
                    bT(n, start + 1);
                    board[start][j] = '.';
                }
            }
        }
    }

    public boolean check(int x, int y){
        // col
        int n = board.length;
        for(int i = 0; i < x; i++){
            if(board[i][y] == 'Q') return false;
        }
        // row
        for(int j = 0; j < y; j++){
            if(board[x][j] == 'Q') return false;
        }
        // dia
        for(int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q') return false;
        }        
        // anti-dia
        for(int i = x - 1, j = y + 1; i >= 0 && j < n ; i--, j++){
            if(board[i][j] == 'Q') return false;
        }    
        return true;
    }
}
