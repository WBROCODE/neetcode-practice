class NumMatrix {
    /**
    1 2 3       
    4 5 6       
    7 8 9
    
    A B C
    D E F
    G H I 

    A + B + D + E = (A + D) + (A + B) + E - A 
    
                p[i][j] = p[i - 1][j] + p[i][j - 1] 
    1  3  6
    5 12 21     
   12 27 45
            E + F + H + I = A + B + C + D + E + F + G + H + I 
                            - A - B - C
                            - A - D - G 
                            + A
    */
    int[][] prefix;     
    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        prefix = new int[m + 1][n + 1];
        int total = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                prefix[i][j] = matrix[i - 1][j - 1] 
                + prefix[i - 1][j] 
                + prefix[i][j - 1]
                - prefix[i-1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix[row2 + 1][col2 + 1] 
                    - prefix[row2 + 1][col1] 
                    - prefix[row1][col2 + 1] 
                    + prefix[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */