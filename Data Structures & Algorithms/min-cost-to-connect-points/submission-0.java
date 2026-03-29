class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        Map<Integer, List<int[]>> graph = new HashMap<>();

        for(int i = 0 ; i < n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int i = 0 ; i < n; i++){
            int preX = points[i][0];
            int preY = points[i][1];

            for(int j = i + 1; j < n; j++){
                int x = points[j][0];
                int y = points[j][1];

                int dis = Math.abs(x - preX) + Math.abs(y - preY);
                graph.get(i).add(new int[]{j, dis});
                graph.get(j).add(new int[]{i, dis});
            }
        }
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);
        pq.offer(new int[]{0, 0});
        
        int ans = 0;
        int count = 0;
        while(count < n){
            int[] cur = pq.poll();
            int to = cur[0], dis = cur[1];
            if(visited[to]) continue;
            
            visited[to] = true;
            ans += dis;
            count++;

            List<int[]> nexts =  graph.get(to); 
            for(int[] next : nexts){
                int nextTo = next[0], nextDis = next[1];
                if(!visited[nextTo]){
                    pq.offer(new int[]{nextTo, nextDis});
                }
            }
        }
        return ans;
    }
}
