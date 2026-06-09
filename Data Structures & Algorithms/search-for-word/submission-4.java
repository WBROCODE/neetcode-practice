class Solution {
    int[][] dirs = new int[][]{
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    boolean[][] visited;
    boolean found = false;
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(word.charAt(0) == board[i][j]){
                    backTrack(board, word, 0, i, j, m, n);
                }
            }
        }
        return found;
    }

    public void backTrack(char[][] board, String word, int len, int i, int j, int m, int n){
        if(i < 0 || j < 0 || i >= m || j >= n || found || visited[i][j] || word.charAt(len) != board[i][j]) return;
        
        if(len == word.length() - 1){
            found = true;
            return;
        }
        
        visited[i][j] = true;
        for(int[] dir : dirs){
            backTrack(board, word,len + 1, i + dir[0], j + dir[1], m, n);
        }
        visited[i][j] = false;

    }
}
