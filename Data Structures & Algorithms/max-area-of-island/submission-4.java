class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        if(grid == null || grid.length == 0 || grid[0].length == 0) return ans;
       
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    ans = Math.max(bfs(grid, i, j), ans);
                }
            }
        }
        return ans;
    }
    int[][] directions = new int[][]{
        {0, 1},   
        {1, 0},   
        {0, -1},  
        {-1, 0}   
    };
    
    public int bfs(int[][] grid, int i, int j){
        Deque<int[]> deque = new LinkedList<>();
        grid[i][j] = 0;
        deque.offer(new int[]{i, j});
        int ans = 1;

        while(!deque.isEmpty()){
            int size = deque.size();
            for(int p = 0; p < size; p++){
                int[] cur = deque.poll();
                // check boarder & critiria
                int x = cur[0], y = cur[1];
                
                for(int k = 0; k < 4; k++){
                    int newX = cur[0] + directions[k][0];
                    int newY = cur[1] + directions[k][1];
                    if(newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length
                    || grid[newX][newY] == 0) continue;
                    deque.offer(new int[]{newX, newY});
                    grid[newX][newY] = 0;
                    ans++;
                }
            }
        }
        return ans;
    }

}
