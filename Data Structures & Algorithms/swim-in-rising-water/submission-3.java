class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        /**
        Graph
        PQ
        bfs 
            within board -> Max prev - cur -> put cur
        */
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2] - b[2]);
        pq.offer(new int[]{0, 0, grid[0][0]});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        int[][] dirs = new int[][]{
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
        };

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int i = cur[0], j = cur[1], prev = cur[2];
            if(i == n - 1 && j == n - 1) return prev;
            for(int[] dir : dirs){
                int x = dir[0] + i, y = dir[1] + j;
                if(x < 0 || y < 0 || x >=n || y >= n || visited[x][y]) continue;
                int val = grid[x][y]; 
                visited[x][y] = true;
                val = Math.max(val, prev);
                pq.offer(new int[]{x, y, val});
            }
        }

        return -1;
    }
}
