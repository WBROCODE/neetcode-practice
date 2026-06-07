class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // dfs
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++)
                if(grid[i][j] == 1){
                    int area = dfs(i, j, m, n, grid);
                    ans = Math.max(area, ans);
                }
        }

        return ans;
    }

    int[][] dirs = new int[][]{
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public int dfs(int i, int j, int m, int n, int[][] grid){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        int area = 1;

        for(int[] dir : dirs){
            area += dfs(i + dir[0], j + dir[1], m, n, grid);
        }
        return area;
    }
}
