class Solution {
    public int minCostConnectPoints(int[][] points) {
        // build up graph
        int n = points.length;
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                int[] pre = points[i];
                int[] cur = points[j];
                int preX = pre[0], preY = pre[1], curX = cur[0], curY = cur[1];
                int dis = Math.abs(preX - curX) + Math.abs(preY - curY);
                graph[i].add(new int[]{j, dis});
                graph[j].add(new int[]{i, dis});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);
        pq.offer(new int[]{0, 0});
        boolean[] visited = new boolean[n];
        // bfs
        int ans = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curP = cur[0], curD = cur[1];
            if(visited[curP]) continue;
            ans += curD;
            visited[curP] = true;
            for(int[] next : graph[curP]){
                int nextP = next[0], nextD = next[1];
                if(visited[nextP]) continue;
                pq.offer(next);
            }
        }

        return ans;
    }
}
