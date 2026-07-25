class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = buildUpGraph(times, n);
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->a[1] - b[1]
        );

        pq.offer(new int[]{k, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curP = cur[0];
            int curCost = cur[1];
            if(curCost >= distances[curP]) continue;
            distances[curP] = curCost;
            for(int[]next : graph[curP]){
                if(curCost + next[1] < distances[next[0]]){
                    pq.offer(new int[]{next[0], curCost + next[1]});
                    
                }
            }
        }
        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(distances[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, distances[i]);
        }
        return ans;
    }

    public List<int[]>[] buildUpGraph(int[][] times, int n){
        List<int[]>[] graph = new List[n + 1];
        
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }


        for(int[] time : times){
            int from = time[0];
            int to = time[1];
            int cost = time[2];
            graph[from].add(new int[]{to, cost});
        }
        return graph;
    }
}
