class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights == null || heights[0].length == 0) return new ArrayList<>();

        int m = heights.length, n = heights[0].length;

        Queue<int[]> queuePac= new LinkedList<>();
        Queue<int[]> queueAlt= new LinkedList<>();
        boolean[][] pac = new boolean[m][n];
        boolean[][] alt = new boolean[m][n];
        // from end to start
        for(int j = 0; j < n; j++){
            queuePac.offer(new int[]{m - 1, j});
            pac[m - 1][j] = true;
            queueAlt.offer(new int[]{0, j});
            alt[0][j] = true;
        }

        for(int i = 0; i < m; i++){
            queuePac.offer(new int[]{i, n - 1});
            pac[i][n - 1] = true;
            queueAlt.offer(new int[]{i, 0});
            alt[i][0] = true;
        }


        bfs(queuePac, pac, heights);
        bfs(queueAlt, alt, heights);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pac[i][j] && alt[i][j]) ans.add(List.of(i, j));
            }
        }

        return ans;
    }

    public boolean[][] bfs(Queue<int[]> queue, boolean[][] visited, int[][] heights){
        int m = heights.length, n = heights[0].length;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int prev = heights[x][y];
            for(int[] dir : dirs){
                int newX = dir[0] + x;
                int newY = dir[1] + y;
                if(newX < 0 || newX >= m || newY < 0 || newY >= n || visited[newX][newY]) continue;
                if(prev > heights[newX][newY]) continue;
                visited[newX][newY] = true;
                queue.offer(new int[]{newX, newY});
            }
        }
        return visited;
    }

    int[][] dirs = new int[][]{
        {-1, 0},
        {1, 0},
        {0, 1},
        {0, -1}
    };
}
