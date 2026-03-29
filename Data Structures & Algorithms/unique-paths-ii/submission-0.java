class Solution {
    int[][] memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        memo = new int[m][n];

        return dp(obstacleGrid, 0, 0);
    }

    public int dp(int[][] obstacleGrid, int i, int j){
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if(i >= m || j >= n || obstacleGrid[i][j] == 1) return 0;
        if(i == m - 1 && j == n - 1) return 1;
        if(memo[i][j] != 0) return memo[i][j];

       
        memo[i][j] = dp(obstacleGrid,  i + 1, j) + dp(obstacleGrid, i, j + 1);
        
      
        return memo[i][j];
    }
}