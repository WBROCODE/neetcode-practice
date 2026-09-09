class Solution {
    
    public int shortestBridge(int[][] grid) {
        /**
            DFS record visited



            BFS -> shortest 
        */
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        boolean found = false;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(found) break;
            for(int j = 0; j < n; j++){     
                if(grid[i][j] == 1 && !found && !visited[i][j]){
                    dfs(i, j, n, grid, visited, q);
                    found = true;
                }
            }
        }
        int ans = 0;
        int[][] dirs = new int[][]{
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
        };

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];
                for(int[] dir : dirs){
                    int newX = dir[0] + x, newY = dir[1] + y;
                    if(newX < 0 || newX >= n || newY < 0 || newY >= n || visited[newX][newY]) continue;
                    if(grid[newX][newY] == 1) return ans;
                    q.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
            ans++;
        }

        return -1;
    }

    public void dfs(int i, int j, int n, int[][] grid, boolean[][] visited, Queue<int[]> q){
        if(i < 0 || i >= n || j < 0 || j >= n || grid[i][j] == 0 || visited[i][j]) return;
        visited[i][j]= true;
        q.offer(new int[]{i, j});
        dfs(i + 1, j, n, grid, visited, q);
        dfs(i - 1, j, n, grid, visited, q);
        dfs(i, j + 1, n, grid, visited, q);
        dfs(i, j - 1, n, grid, visited, q);
    }
}