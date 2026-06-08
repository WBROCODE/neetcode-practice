class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int prevX = points[i][0];
                int prevY = points[i][1];

                int curX = points[j][0];
                int curY = points[j][1];

                int cost = Math.abs(prevX - curX) + Math.abs(prevY - curY); 
                graph[i].add(new int[]{j, cost});
                graph[j].add(new int[]{i, cost});
            }
        }
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);
        for(int[]s : graph[0]){
            pq.offer(s);
        }
        visited[0] = true;
        int cost = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curP = cur[0];
            int curCost = cur[1];

            if(visited[curP]) continue;
            visited[curP] = true;
            cost += curCost;

            for(int[] next : graph[curP]){
                int nextP = next[0];
                int nextCost = next[1];

                if(!visited[nextP]){
                    pq.offer(next);
                }
            }
        }
        return cost;
    }
}
