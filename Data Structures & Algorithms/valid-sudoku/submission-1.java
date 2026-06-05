class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] boxes = new int[9][9];

        for(int i = 0; i <= 8; i++){
            for(int j = 0; j <= 8; j++){
                if(board[i][j] == '.') continue;
                int num = board[i][j] - '1';
                // check row 
                if(rows[i][num] == 1) return false;
                rows[i][num] = 1;
                // check cols 
                if(cols[j][num] == 1) return false;
                cols[j][num] = 1;
                // check boxes 
                int index = i / 3 + j / 3 * 3;
                if(boxes[index][num] == 1) return false;
                boxes[index][num] = 1;
            }
        }
        return true;
    }


}
