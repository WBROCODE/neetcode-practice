class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }else if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
            }    
        }
        if(fresh == 0) return 0;
        int[][] dirs = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                for(int[] dir : dirs){
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if(newX < 0 || newY < 0 || newX >= m || newY >= n || grid[newX][newY] == 0 || grid[newX][newY] == 2) continue;
                    queue.offer(new int[]{newX, newY});
                    grid[newX][newY] = 2;
                    fresh--;
                    if(fresh == 0) return time + 1;
                }
            }
            time++;
        }
        return fresh > 0 ? -1 : time;
    }
}
