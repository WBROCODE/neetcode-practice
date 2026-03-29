class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int res = 0;
        int m = grid.length, n = grid[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    res = Math.max(res, bfs(grid, i, j));
                }
            }
        }

        return res;
    }

    public int bfs(int[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        grid[i][j] = 0;

        int len = 1;
        while(!q.isEmpty()){
            int[]cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            for(int[] dir : dirs){
                int newX = dir[0] + x;
                int newY = dir[1] + y;
                if(newX < 0 || newY < 0 || newX >= m 
                || newY >= n || grid[newX][newY] == 0) continue;  
                q.offer(new int[]{newX, newY});
                grid[newX][newY] = 0;
                len++;
            }
        }
        return len;
    }

    int[][] dirs = new int[][]{
            {0,-1},
            {1,0},
            {-1,0},
            {0,1},
    };
}
