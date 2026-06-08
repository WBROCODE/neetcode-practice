class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }else if(grid[i][j] == 2) queue.offer(new int[]{i,j});
            }
        }
        int[][] dirs = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };
        int time = 0;
        while(!queue.isEmpty() && fresh > 0){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];

                for(int[] dir : dirs){
                    int newX = dir[0] + x, newY = dir[1] + y;
                    if(newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 1) continue;
                    fresh--;
                    grid[newX][newY] = 2;
                    queue.offer(new int[]{newX, newY});
                }
            }
            time++;
        }
        if(fresh > 0) return -1;

        return time;
    }
}
