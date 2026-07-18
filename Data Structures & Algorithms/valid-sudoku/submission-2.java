class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int[][] col = new int[9][9];
        int[][] row = new int[9][9];
        int[][] box = new int[9][9];

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                int num = board[i][j] - '1';
                if(col[i][num] == 1) return false;
                col[i][num] = 1;
                if(row[j][num] == 1) return false;
                row[j][num] = 1;
                int index = (i / 3) * 3 + j / 3;
                if(box[index][num] == 1) return false;
                box[index][num] = 1;
            }
        }
        return true;
    }
}
