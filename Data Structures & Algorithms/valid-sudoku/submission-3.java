class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] cols = new boolean[9][9];
        boolean[][] rows = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char ch = board[i][j];
                if(ch == '.') continue;
                int num = ch - '1';
                if(cols[i][num]) return false;
                cols[i][num] = true;
                if(rows[j][num]) return false;
                rows[j][num] = true;
                int index = i / 3 + j / 3 * 3;
                if(boxes[index][num]) return false;
                boxes[index][num] = true;
            }
        }

        return true;
    }
}
