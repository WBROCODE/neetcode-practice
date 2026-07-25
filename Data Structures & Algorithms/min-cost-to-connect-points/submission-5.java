class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]>[] graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int curX = points[j][0];
                int curY = points[j][1];
                int preX = points[i][0];
                int preY = points[i][1];
                int distance = Math.abs(curX - preX) + Math.abs(curY - preY);
                graph[i].add(new int[]{j, distance});
                graph[j].add(new int[]{i, distance});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);
        for(int[] p : graph[0]){
            pq.offer(p);
        }
        
        boolean[]visited = new boolean[n];
            visited[0] = true;
        int ans = 0;
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curP = cur[0];
            
            if(visited[curP]) continue;
            visited[curP] = true;
            ans += cur[1];
            for(int[] nextP : graph[curP]){
                if(!visited[nextP[0]]){
                    pq.offer(nextP);
                }
            }
        }
        return ans;
    }
}
