class Solution {
    int[][] dirs = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int fresh = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    dfs(i, j, m, n, grid);
                }
            }
        }
        int time = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    return -1;
                }else time = Math.max(time, grid[i][j]);
            }
        }

        return time - 2;
    }

    public void dfs(int i, int j, int m, int n, int[][]grid){
        
        for(int[] dir : dirs){
            int newX = dir[0] + i, newY = dir[1] + j;
            if(newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] == 0) continue;
            if(grid[newX][newY] == 1 || grid[newX][newY] > grid[i][j] + 1){
                grid[newX][newY] = (grid[i][j] + 1);
                dfs(newX, newY, m, n, grid);
            }   
            
        }
    }
}
