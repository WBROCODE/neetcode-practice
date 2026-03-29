class Solution {
    public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        int n = points.length;
        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int preX = points[i][0];
                int preY = points[i][1];
                
                int curX = points[j][0];
                int curY = points[j][1];     
                int dis = Math.abs(curX - preX) +  Math.abs(curY - preY);

                graph.get(i).add(new int[]{j, dis});
                graph.get(j).add(new int[]{i, dis});
            }

        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);
        for(int[] next : graph.get(0)){
            pq.offer(next);
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int total = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int to = cur[0];
            int dis = cur[1];
            if(visited[to]) continue;
            visited[to] = true;
            total += dis;

            for(int[]next : graph.get(to)){
                int toNext = next[0];
                int nextDis = next[1];

                if(!visited[toNext]){
                    pq.offer(next);
                    
                }
            }
        }
        return total;
    }

    
}
