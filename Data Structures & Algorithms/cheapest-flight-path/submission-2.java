class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] flight : flights){
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];
            graph[from].add(new int[]{to, cost});
        }

        int[][] distance = new int[n][k + 2];
        for(int[] d : distance){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        distance[src][k + 1] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[1] - b[1]);
        q.offer(new int[]{src, 0, k + 1});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int from = cur[0];
            int cost = cur[1];
            int remainK = cur[2];
            if(from == dst && remainK >= 0) return cost;
            if(cost > distance[from][remainK]) continue;
            if(remainK == 0) continue;
            for(int[] next : graph[from]){
                int nextTo = next[0], nextCost = next[1];
                if(remainK - 1 >= 0 && nextCost + cost < distance[nextTo][remainK - 1]){
                    distance[nextTo][remainK - 1] = nextCost + cost;
                    q.offer(new int[]{nextTo, distance[nextTo][remainK - 1], remainK - 1});
                }
            }
        }

        return -1;
    }
}
