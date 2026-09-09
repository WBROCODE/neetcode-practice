class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacToAlt = new boolean[m][n];
        boolean[][] altToPac = new boolean[m][n];

        for(int i = 0; i < m; i++){
            dfs(i, 0, m, n, heights, pacToAlt, heights[i][0]);
            dfs(i, n - 1, m, n, heights, altToPac, heights[i][n - 1]);
        }

        for(int j = 0; j < n; j++){
            dfs(0, j, m, n, heights, pacToAlt, heights[0][j]);
            dfs(m - 1, j, m, n, heights, altToPac, heights[m - 1][j]);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pacToAlt[i][j] && altToPac[i][j]){
                    ans.add(List.of(i, j));
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
    
    public void dfs(int i, int j, int m, int n, int[][] heights, boolean[][] visited, int prev){
        if(i < 0 || i >= m || j < 0 || j >= n || heights[i][j] < prev || visited[i][j]) return;

        visited[i][j] = true;
        for(int[] d : dirs){
            dfs(i + d[0], j + d[1], m, n, heights, visited, heights[i][j]);
        }

    }
}
