class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();

        int m = heights.length, n = heights[0].length;

        boolean[][] pac= new boolean[m][n]; 
        boolean[][] alt = new boolean[m][n];
         
        Queue<int[]> pacToAlt = new LinkedList<>();
        Queue<int[]> altToPac = new LinkedList<>();

        for(int i = 0; i < m; i++){
            pac[i][0] = true;
            pacToAlt.offer(new int[]{i, 0, heights[i][0]});
            alt[i][n - 1] = true;
            altToPac.offer(new int[]{i, n - 1, heights[i][n - 1]});
        }

        for(int j = 0; j < n; j++){
            altToPac.offer(new int[]{m - 1, j, heights[m - 1][j]});
            alt[m - 1][j] = true;
            pac[0][j] = true;
            pacToAlt.offer(new int[]{0, j, heights[0][j]});
        }

        bfs(pacToAlt, pac, heights);
        bfs(altToPac, alt, heights);

        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(pac[i][j] && alt[i][j]){
                    ans.add(List.of(i,j));
                }
            }
        }

        return ans;
    }

    int[][] dirs = new int[][]{
        {-1, 0},
        {1, 0},
        {0, 1},
        {0, -1}
    };

    public void bfs(Queue<int[]> queue,  boolean[][] visited, int[][] heights){
        int m = visited.length, n = visited[0].length;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], prevV = cur[2];
            for(int[] dir : dirs){
                int newX = dir[0] + x, newY = dir[1] + y;
                if(newX < 0 || newX >= m || newY < 0 || newY >= n || visited[newX][newY]) continue;
                int curV = heights[newX][newY];
                if(curV < prevV) continue;
                visited[newX][newY] = true;
                queue.offer(new int[]{newX, newY, curV});
            }
        }
    }
}
