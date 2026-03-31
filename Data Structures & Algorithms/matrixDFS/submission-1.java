class Solution {
    HashSet<String> visited;
    int ans;
    public int countPaths(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        visited = new HashSet<>();
        ans = 0;
        dfs(grid, m, n, 0, 0);

        return ans;
    }

    public void dfs(int[][] grid, int m, int n, int x, int y){
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 1 
        || visited.contains(x + "," + y)) return;

        if(x == m - 1 && y == n - 1){
            ans++;
            return;
        }
        visited.add(x + "," + y);
        for(int[] dir : dirs){
            dfs(grid, m, n, x + dir[0], y + dir[1]);
        }

        visited.remove(x + "," + y);
    }

    int[][] dirs = new int[][]{
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };


}

