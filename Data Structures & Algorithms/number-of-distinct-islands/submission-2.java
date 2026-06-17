class Solution {
    StringBuilder sb;
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    sb = new StringBuilder();
                    dfs(grid, m, n, i, j, 0);
                    set.add(sb.toString());
                }
            }
        }

        return set.size();

    }

    public void dfs(int[][]grid, int m, int n, int i, int j, int mark){
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return;

        sb.append(mark);
        grid[i][j] = 0;
        dfs(grid, m, n, i + 1, j, 1);
        dfs(grid, m, n, i - 1, j, 2);
        dfs(grid, m, n, i, j - 1, 3);
        dfs(grid, m, n, i, j + 1, 4);
        sb.append(-mark);
    }
}
