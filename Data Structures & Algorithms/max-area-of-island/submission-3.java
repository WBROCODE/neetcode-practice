class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;

        if(grid == null || grid.length == 0
        || grid[0] == null||grid[0].length == 0) return ans;

        for(int i =0; i < grid.length; i++){
            for(int j =0; j < grid[0].length; j++){
                if(grid[i][j] == 1) ans = Math.max(dfs(grid, i, j), ans);
            }
        }
        
        return ans;
    }

    public int dfs(int[][] grid, int i, int j){
        if(grid == null || grid.length == 0
        || grid[0] == null || grid[0].length == 0) return 0;

        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 0;
        if(grid[i][j] == 0) return 0;

             
        grid[i][j] = 0;
        
        int ans = 1;
        ans+=dfs(grid, i + 1, j);
        ans+=dfs(grid, i - 1, j);
        ans+=dfs(grid, i, j + 1);
        ans+=dfs(grid, i, j - 1);  

        return ans;   
    }
}
