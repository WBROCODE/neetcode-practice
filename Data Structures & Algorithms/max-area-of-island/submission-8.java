class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // bfs
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++)
                if(grid[i][j] == 1){
                    int area = bfs(i, j, m, n, grid);
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

    public int bfs(int i, int j, int m, int n, int[][] grid){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        int area = 0;
        grid[i][j] = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            area++;
            for(int[] dir : dirs){
                int newX = x + dir[0];
                int newY = y + dir[1];
                if(newX < 0 || newY < 0 || newX >= m || newY >= n || grid[newX][newY] == 0) continue;
                queue.offer(new int[]{newX, newY});
                grid[newX][newY] = 0;
            }
        }
        return area;
    }
}
