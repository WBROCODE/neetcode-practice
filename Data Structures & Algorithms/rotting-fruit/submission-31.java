class Solution {
    public int orangesRotting(int[][] grid) {
        // count fresh
        // count enter
        // bfs
        // fresh > 0 -1 
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }else if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
            }
        }
        if(fresh == 0) return 0;
        int[][] dirs = new int[][]{
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
        };

        int time = 0;
        while(!q.isEmpty()){
            int s = q.size();
            for(int i = 0; i < s; i++){
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];
                for(int[] dir : dirs){
                    int newX = dir[0] + x, newY = dir[1] + y;
                    if(newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 1) continue;
                    q.offer(new int[]{newX, newY});
                    grid[newX][newY] = 2;
                    fresh--;
                }
            }   
            time++;
        }
        return fresh > 0 ?  -1 : time - 1;


    }
}
