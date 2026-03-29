class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int[][] dirs = new int[][]{
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, 1}, {0, -1},
            {1, -1}, {1, 0},{1, 1}
        };
        grid[0][0] = 1;
        int ans = 1;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size; i++){
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                if(x == m - 1 && y == n - 1) return ans;
                
                for(int[] dir : dirs){
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    
                    if(newX < 0 || newY < 0 || newX >= m || newY >= n) continue;
                    
                    if(grid[newX][newY] == 1) continue;   
                    
                    grid[newX][newY] = 1;
                    
                    queue.offer(new int[]{newX, newY});
                }   
            }
            ans++;
        }
        return -1;
    }


}