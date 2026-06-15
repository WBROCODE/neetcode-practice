class Solution {
    public int swimInWater(int[][] grid) {
        int[][] dirs = new int[][]{
            {-1, 0},
            {0, 1},
            {0, -1},
            {1, 0}
        };

        int n = grid.length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[2] - b[2]);
        q.offer(new int[]{0, 0, grid[0][0]});
        
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

         while(!q.isEmpty()){
            int[] cur = q.poll();
            int i = cur[0], j = cur[1], val = cur[2];
            if(i == n - 1 && j == n -1) return val;

            for(int[]dir : dirs){
                int x = dir[0] + i, y = dir[1] + j;
                if( x >= 0 && x <= n -1 && y >= 0 && y <= n - 1){
                    int nextVal = Math.max(val, grid[x][y]);
                    if(!visited[x][y]){
                        q.offer(new int[]{x, y, nextVal});
                        visited[x][y] = true;
                    }
                }
            }
        }

        return -1;
    }
}
