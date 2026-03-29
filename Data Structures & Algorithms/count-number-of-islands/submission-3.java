class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null  || grid[0].length == 0) return 0;

        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void bfs(char[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        grid[i][j] = '0';

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int[]dir : dirs){
                int newX = cur[0] + dir[0];
                int newY = cur[1] + dir[1];
                if(newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] == '0') continue;
                q.offer(new int[]{newX, newY});
                grid[newX][newY] = '0';        
            }
        }
    }
    
    int[][] dirs = new int[][]{
        {-1, 0},
        {0, 1},
        {0, -1},
        {1, 0},
    };
}
