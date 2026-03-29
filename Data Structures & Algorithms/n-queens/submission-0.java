class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        StringBuilder sb = new StringBuilder();
        // build board
        List<String> board = new ArrayList<>();
        for(int i = 0; i < n; i++){
            sb.append('.');
        }
        for(int i = 0; i < n; i++){
            board.add(sb.toString());
        }
        dfs(board, 0, n);
        return ans;
    }

    public void dfs(List<String> board, int x, int n){
        if(x == n){
            ans.add(new ArrayList<>(board));
            return;
        }

        for(int j = 0; j < n; j++){  
            // check rule
            if(!isValid(board, x, j, n)) continue;
            // set Q
            char[] row = board.get(x).toCharArray();
            row[j] = 'Q';
            board.set(x, new String(row));

            dfs(board, x + 1, n);
            row[j] = '.';
            board.set(x, new String(row));
        }
    }

    public boolean isValid(List<String> board, int i, int j, int n){
        // horizo
        for(int col = 0; col < j; col++){
            if(board.get(i).charAt(col) == 'Q') return false;
        }
        // vertical
        for(int row = 0; row < i; row++){
            if(board.get(row).charAt(j) == 'Q') return false;
        }
        // dial
        for(int k = i - 1, p = j - 1; k >= 0 && p >= 0; k--, p--){
            if(board.get(k).charAt(p) == 'Q') return false;
        }

        for(int k = i - 1, p = j + 1; k >= 0 && p <= n - 1; k--, p++){
            if(board.get(k).charAt(p) == 'Q') return false;
        }
        return true;
    }

    

    

    
}
