class Solution {
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = buildUpGraph(flights, n);
        int[][] costs = new int[n][k + 2];
        for(int[] cost : costs){
             Arrays.fill(cost, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);
        pq.offer(new int[]{src, 0, k + 1});
        costs[src][k + 1] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curCost = cur[1];
            int curK = cur[2];
            if(curNode == dst) return curCost;
            if(curK == 0) continue;
            if(curCost > costs[curNode][curK]) continue;

            for(int[]next : graph[curNode]){
                int nextNode = next[0];
                int nextCost = next[1];
                int remainK = curK - 1;
                if(remainK >= 0 && costs[curNode][curK] + nextCost < costs[nextNode][remainK]){
                    costs[nextNode][remainK] = curCost + nextCost;
                    pq.offer(new int[]{nextNode, costs[nextNode][remainK], remainK});
                }
            }
        }

        return -1;
    }

    public List<int[]>[] buildUpGraph(int[][] edges, int n){
        List<int[]>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];
            graph[from].add(new int[]{to, cost});
        }
        return graph;
    }
}
