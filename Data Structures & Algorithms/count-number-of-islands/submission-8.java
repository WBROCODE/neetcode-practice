class Solution {
    public int numIslands(char[][] grid) {
        // bfs
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++)
                if(grid[i][j] == '1'){
                    bfs(i, j, m, n, grid);
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

    public void bfs(int i, int j, int m, int n, char[][] grid){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for(int[] dir : dirs){
                int newX = x + dir[0];
                int newY = y + dir[1];
                if(newX < 0 || newY < 0 || newX >= m || newY >= n || grid[newX][newY] == '0') continue;
                queue.offer(new int[]{newX, newY});
                grid[newX][newY] = '0';
            }
        }

    }
}
