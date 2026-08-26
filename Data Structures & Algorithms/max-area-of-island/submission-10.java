class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // dfs
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    ans = Math.max(dfs(i, j, m, n, grid), ans);
                }
            }
        }

        return ans;
    }

    public int dfs(int i, int j, int m, int n, int[][] grid){
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return 0;

        grid[i][j] = 0;
        int ans = 1;
        ans += dfs(i + 1, j, m, n, grid);
        ans += dfs(i - 1, j, m, n, grid);
        ans += dfs(i, j + 1, m, n, grid);
        ans += dfs(i, j - 1, m, n, grid);

        return ans;
    }
}
