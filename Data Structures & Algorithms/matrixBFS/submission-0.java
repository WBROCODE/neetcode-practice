class Solution {
    public int shortestPath(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        if(grid[m - 1][n - 1] == 1) return -1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;
        int[][] dirs = new int[][]{
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
        };

        int ans = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                int curX = cur[0], curY = cur[1];
                if(curX == m - 1 && curY == n - 1) return ans;
                for(int[] dir : dirs){
                    int nextX = dir[0] + curX;
                    int nextY = dir[1] + curY;

                    if(nextX < 0 || nextX >= m || nextY < 0 
                    || nextY >= n || grid[nextX][nextY] == 1
                    ) continue;
                    queue.offer(new int[]{nextX, nextY});
                    grid[nextX][nextY] = 1;
                }
            }
            ans++;
        }

        return -1;
    }
}
