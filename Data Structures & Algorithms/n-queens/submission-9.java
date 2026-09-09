class Solution {
    List<List<String>> ans;
    char[][] board; 
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        backTrack(n, 0);

        return ans;
    }
    // backTrack 
    public void backTrack(int n, int x){
        if(x == n){
            // add ans 
            List<String> temp = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for(char[] chs : board){
                for(char ch : chs){
                    sb.append(ch);
                }
                temp.add(sb.toString());
                sb = new StringBuilder();
            }
          
            ans.add(temp);
            return;
        }
        
        for(int y = 0; y < n; y++){
            if(check(x, y, n)){
                board[x][y] = 'Q'; 
                backTrack(n, x + 1);
                board[x][y] = '.'; 
            }
        }

    }
    // check 
    public boolean check(int x, int y, int n){
        for(int i = x - 1; i >= 0; i--){
            if(board[i][y] == 'Q') return false;
        }   

        for(int j = y - 1, i = x - 1; j >= 0 &&  i >= 0; j--, i--){
            if(board[i][j] == 'Q') return false;
        }   

        for(int j = y + 1, i = x - 1; j < n && i >= 0; j++, i--){
            if(board[i][j] == 'Q') return false;
        }   
        return true;
    }



}
