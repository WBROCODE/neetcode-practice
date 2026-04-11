class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean found = true;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                   if(backTrack(board, word, visited, i, j, 0)) return true;
                }        
            }
        }
        return false;
    }

    public boolean backTrack(char[][] board, String word, boolean[][] visited,
    int i, int j, int len){
        int m = board.length, n = board[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || word.charAt(len) != board[i][j]) return false;
        if(len + 1 == word.length() ){
            return true;
        }
        visited[i][j] = true;   
        boolean found = backTrack(board, word, visited, i + 1, j, len + 1)
        || backTrack(board, word, visited, i - 1, j, len + 1)
        || backTrack(board, word, visited, i, j + 1, len + 1)
        || backTrack(board, word, visited, i, j - 1, len + 1);
        visited[i][j] = false;

        return found;
    }
}
