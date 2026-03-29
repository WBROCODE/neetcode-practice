class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
    
        List<int[]> start = new ArrayList<>();
        int fresh = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2){
                    start.add(new int[]{i, j});
                }
            }
        }
        if(fresh == 0) return 0;
     
        Queue<int[]> q = new LinkedList<>();
        for(int[] s : start){
            q.offer(s);
        }

        int time = 0;
        while(!q.isEmpty()){
            int s = q.size();
            for(int p = 0; p < s; p++){
                int[] cur = q.poll();
                int i = cur[0];
                int j = cur[1];
                for(int[] dir : dirs){
                    int newX = dir[0] + i;
                    int newY = dir[1] + j;
                    if(newX < 0 || newY < 0 || newY >= n || newX >= m || grid[newX][newY] != 1) continue;
                    grid[newX][newY] = 2;
                    q.offer(new int[]{newX, newY});
                }
            }
            time++;
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return time - 1;
    }

    int[][] dirs = new int[][]{
        {-1, 0},
        {1, 0},
        {0, 1},
        {0, -1}
    };
}
