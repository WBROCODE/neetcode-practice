class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    ans = Math.max(dfs(grid, i, j), ans);
                }
            }
        }

        return ans;
    }

     public int dfs(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;     
        // boarder
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return 0;
         
        // set visited
        grid[i][j] = 0;
        int size = 1;
        // next stage
        for(int[] dir : dirs){
            size += dfs(grid, i + dir[0] , j + dir[1]);
        }
        return size;

    }

    public int[][] dirs = new int[][]{
        {-1, 0},
        {1, 0},
        {0, 1},
        {0, -1}
    };
}
