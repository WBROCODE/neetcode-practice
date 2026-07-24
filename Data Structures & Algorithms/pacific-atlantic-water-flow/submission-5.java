class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] grid) {
        List<List<Integer>> ans = new ArrayList<>();

        int m = grid.length, n = grid[0].length;

        boolean[][] pacToAlt = new boolean[m][n];
        boolean[][] altToPac = new boolean[m][n];

        for(int i = 0; i < n; i++){
            pacToAlt[0][i] = true;
            altToPac[m - 1][0] = true;
        }

        for(int i = 0; i < m; i++){
            pacToAlt[i][0] = true;
            altToPac[i][n - 1] = true;
        }      

        for(int i = 0; i < n; i++){
            bfs(0, i, m, n, grid, pacToAlt);
            bfs(m - 1, i, m, n, grid, altToPac);
            
        }

        for(int i = 0; i < m; i++){
            bfs(i, 0, m, n, grid, pacToAlt);
            bfs(i, n - 1, m, n, grid, altToPac);
        }


        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(pacToAlt[i][j] && altToPac[i][j]){
                    ans.add(List.of(i,j));
                }
            }
        }

        return ans;
    }

    int[][] dirs = new int[][]{
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public void bfs(int i, int j, int m, int n, int[][] grid, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            visited[x][y] = true;
            for(int[] dir : dirs){
                int newX = x + dir[0];
                int newY = y + dir[1];
                if(newX < 0 || newY < 0 || newX >= m || newY >= n || visited[newX][newY] || grid[newX][newY] < grid[x][y] ) continue;
                queue.offer(new int[]{newX, newY});       
            }
        }
    }
}
