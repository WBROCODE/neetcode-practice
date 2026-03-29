class Solution {
    public int swimInWater(int[][] grid) {
        if(grid == null || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[2] - b[2]);
        q.offer(new int[]{0, 0, grid[0][0]});
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1]; 
            int time = cur[2];
            if(x == m - 1 && y == n - 1) return time;
            for(int[] dir : dirs){
                int newX = dir[0] + x;
                int newY = dir[1] + y;
                if(newX < 0 || newY < 0 || newX >= m || newY >= n) continue;
                if(visited[newX][newY]) continue;
                time = Math.max(cur[2], grid[newX][newY]);
                visited[newX][newY] = true;
                q.offer(new int[]{newX, newY, time});
            }
        
        }

        return -1;
    }

    int[][] dirs = new int[][]{
        {-1, 0},
        {1, 0},
        {0, 1},
        {0, -1},
    };
}
