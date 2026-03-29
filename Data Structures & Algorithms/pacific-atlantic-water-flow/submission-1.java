class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        
        // from Alt to Pac
        boolean[][]visitedOne = new boolean[m][n];
        List<int[]> startOne = new ArrayList<>();
        for(int i = m - 1; i >=0; i--){
            startOne.add(new int[]{i, n - 1});
        }
        for(int j = n - 2; j >=0; j--){
            startOne.add(new int[]{m-1, j});
        }
        bfs(heights, visitedOne, startOne);
        
        // from Pac to Alt
        List<int[]> startTwo = new ArrayList<>();
        boolean[][]visitedTwo = new boolean[m][n];
        for(int i = 0; i <= m - 1; i++){
            startTwo.add(new int[]{i, 0});
        }
        for(int j = 1; j <= n - 1; j++){
            startTwo.add(new int[]{0, j});
        }
        bfs(heights, visitedTwo, startTwo);

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visitedOne[i][j] && visitedTwo[i][j]){
                    ans.add(List.of(i, j));
                }
            }
        }

        return ans;
    }

    public void bfs(int[][] heights, boolean[][] visited, List<int[]> starts){
        Queue<int[]> q = new LinkedList<>();
        int m = heights.length, n = heights[0].length;
        for(int[] start : starts){
            q.offer(start);
            visited[start[0]][start[1]] = true;
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int i = cur[0];
            int j = cur[1];
            int preVal = heights[i][j];
            for(int[] dir : dirs){
                int newX = dir[0] + i;
                int newY = dir[1] + j;
                if(newX < 0 || newY < 0 || newX >= m || newY >= n || visited[newX][newY]) continue;
                int newVal = heights[newX][newY];
                if(newVal < preVal) continue;
                visited[newX][newY] = true;
                q.offer(new int[]{newX, newY});
            }
        }

    }
    int[][] dirs = new int[][]{
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1},
    };
}
