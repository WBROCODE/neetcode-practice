class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int ans = 0;
        int m = grid.length, n = grid[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    grid[i][j] = '0';
                    bfs(i, j, grid, m, n);
                    ans++;
                }
            }
        }

        return ans;
    }
    int[][]dirs = new int[][]{
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };
    public void bfs(int i, int j, char[][]grid, int m, int n){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] dir : dirs){
                int x = dir[0] + cur[0], y = dir[1] + cur[1];
                if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0') continue;
                grid[x][y] = '0';
                queue.offer(new int[]{x, y});
            }
        }
    }


}
