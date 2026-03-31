class Solution {
    boolean[][]visited;
    int ans;
    public int countPaths(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        visited = new boolean[m][n];
        ans = 0;
        dfs(grid, m, n, 0, 0);

        return ans;
    }

    public void dfs(int[][] grid, int m, int n, int x, int y){
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 1 
        || visited[x][y]) return;

        if(x == m - 1 && y == n - 1){
            ans++;
            return;
        }
        visited[x][y] = true;
        for(int[] dir : dirs){
            dfs(grid, m, n, x + dir[0], y + dir[1]);
        }

        visited[x][y] = false;
    }

    int[][] dirs = new int[][]{
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };


}
