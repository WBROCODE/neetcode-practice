class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++){
                if(grid[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for(int[] dir : dirs){
                int newX = x + dir[0];
                int newY = y + dir[1];
                if(newX < 0 || newY < 0 || newX >= m || newY >= n || grid[newX][newY] != 2147483647) continue;
                queue.offer(new int[]{newX, newY});
                grid[newX][newY] = grid[x][y] + 1;
            }
        }
    }
}
