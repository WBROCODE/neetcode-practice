class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }
        int[][] dirs = new int[][]{
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
        };

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                for(int[] dir : dirs){
                    int newX = dir[0] + x, newY = dir[1] + y;
                    if(newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] <= grid[x][y]) continue;
                    queue.offer(new int[]{newX, newY});
                    grid[newX][newY] = (grid[x][y] + 1);
                }
            }
        }

    }
}
