class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }else if(grid[i][j] == 2) queue.offer(new int[]{i, j});
            }
        }
        if(fresh == 0) return 0;

        int m = grid.length, n = grid[0].length;

        int[][] directions = new int[][]{
            {-1, 0},
            {0, -1},
            {1, 0},
            {0, 1}
        };
        
        int ans = 0;
        while(!queue.isEmpty() && fresh > 0){
            int size = queue.size();
            for(int k = 0; k < size ; k++){
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];

                for(int[]dir : directions){
                    int newX = dir[0] + x;
                    int newY = dir[1] + y;
                    if(newX < 0 || newX>= m || newY < 0 || newY >= n 
                    || grid[newX][newY] == 2 || grid[newX][newY] == 0
                    ) continue;

                    grid[newX][newY] = 2;
                    queue.offer(new int[]{newX, newY});
                    fresh--;
                }
            }
            ans++;
        }
        return fresh == 0 ? ans : -1;
    }
}
