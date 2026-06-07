class Solution {
    public int numIslands(char[][] grid) {
        // dfs
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++)
                if(grid[i][j] == '1'){
                    dfs(i, j, m, n, grid);
                    ans++;
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

    public void dfs(int i, int j, int m, int n, char[][] grid){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') return;

        grid[i][j] = '0';

        for(int[] dir : dirs){
            dfs(i + dir[0], j + dir[1], m, n, grid);
        }

    }
}
