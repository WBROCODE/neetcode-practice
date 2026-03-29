class Solution {
    int[][]memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for(int[]next: memo) Arrays.fill(next, -1);
        memo[0][0] = 1;
        return dp(m - 1, n - 1, m, n);
    }

    public int dp(int i, int j, int m, int n){
        if(i < 0 || j < 0 || i >= m || j >= n) return 0;

        if(memo[i][j] != -1) return memo[i][j];

        memo[i][j] = dp(i - 1, j, m, n) 
                    + dp(i, j - 1, m, n);
        return memo[i][j];
    }
}
