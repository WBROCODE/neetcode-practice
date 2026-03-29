class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = buildUpGraph(times, n);
        int[] costs = new int[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);
        pq.offer(new int[]{k, 0});
        costs[k] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curCost = cur[1];
            if(curCost > costs[curNode]) continue;

            for(int[]next : graph[curNode]){
                int nextNode = next[0];
                int nextCost = next[1];
                if(costs[curNode] + nextCost < costs[nextNode]){
                    costs[nextNode] = costs[curNode] + nextCost;
                    pq.offer(new int[]{nextNode, costs[nextNode]});
                }
            }
        }
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            if (costs[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, costs[i]);
        }
        return ans;

    }

    public List<int[]>[] buildUpGraph(int[][] edges, int n){
        List<int[]>[] graph = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++){
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
