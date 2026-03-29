class Solution {
    int[][]memo;
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        memo = new int[m][n];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        int ans = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                ans = Math.max(ans, dp(matrix, i, j));
            }
        }

        return ans;
    }

    public int dp(int[][] matrix, int i, int j){
        int m = matrix.length, n = matrix[0].length;

        if(memo[i][j] != -1) return memo[i][j];

        int ans = 1;
        for(int[] dir : dirs){
            int newX = i + dir[0];
            int newY = j + dir[1];
            if(newX < 0 || newX >= m || newY < 0 || newY >= n) continue;
            if(matrix[newX][newY] > matrix[i][j]){
                ans = Math.max(dp(matrix, newX, newY) + 1, ans);
            }
        }

        memo[i][j] = ans;
        return ans;
    }

    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
}
