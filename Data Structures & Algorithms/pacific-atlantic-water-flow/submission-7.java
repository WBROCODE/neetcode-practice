class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] alt = new boolean[m][n];

        for(int i = 0; i < m; i++){
            dfs(i, 0, m, n, heights, heights[i][0], pac);
            dfs(i, n - 1, m, n, heights, heights[i][n - 1], alt);
        }

        for(int j = 0; j <= n - 1; j++){
            dfs(0, j, m, n, heights, heights[0][j], pac);
            dfs(m - 1, j, m, n, heights, heights[m - 1][j], alt);
        }
        List<List<Integer>> ans= new ArrayList<>();
        for(int i =0 ;i < m; i++){
            for(int j =0 ;j < n; j++){
                if(pac[i][j] && alt[i][j]){
                    ans.add(List.of(i, j));
                }
            }
        }
        return ans;
    }

    public void dfs(int i, int j, int m, int n, int[][] heights, int prev, boolean[][] visited){
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || heights[i][j] < prev) return;
        visited[i][j] = true;
        dfs(i + 1, j, m, n, heights, heights[i][j], visited);
        dfs(i - 1, j, m, n, heights, heights[i][j], visited);
        dfs(i, j + 1, m, n, heights, heights[i][j], visited);
        dfs(i, j - 1, m, n, heights, heights[i][j], visited);
    }
}
