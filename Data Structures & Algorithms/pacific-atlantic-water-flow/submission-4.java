class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // dfs
        List<List<Integer>> ans = new ArrayList<>();

        int m = heights.length, n = heights[0].length;
        boolean[][] pac= new boolean[m][n]; 
        boolean[][] alt = new boolean[m][n];

        for(int i = 0; i < m; i++){
            dfs(i, 0, heights, pac, heights[i][0]);
            dfs(i, n - 1, heights, alt, heights[i][n - 1]);
        }

        for(int j = 0; j < n; j++){
            dfs(0, j, heights, pac, heights[0][j]);
            dfs(m - 1, j, heights, alt, heights[m - 1][j]);
        }

        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(pac[i][j] && alt[i][j]){
                    ans.add(List.of(i,j));
                }
            }
        }
        return ans;
    }
    public void dfs(int i, int j, int[][] heights, boolean[][]visited, int prevV){
        int m = heights.length, n = heights[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || prevV > heights[i][j]) return;

        visited[i][j] = true;
        dfs(i + 1, j, heights, visited,  heights[i][j]);
        dfs(i - 1, j,heights, visited, heights[i][j]);
        dfs(i , j + 1, heights, visited, heights[i][j]);
        dfs(i , j - 1,heights, visited, heights[i][j]);

    }

    int[][] dirs = new int[][]{
        {-1, 0},
        {1, 0},
        {0, 1},
        {0, -1}
    };
}
