class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] t : flights){
            int from = t[0], to = t[1], cost = t[2];
            graph[from].add(new int[]{to, cost});
        }

        int[][] distance = new int[n][k + 2];

        for(int[] d : distance){
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);
        pq.offer(new int[]{src, 0, k + 1});
        distance[src][k + 1] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curP = cur[0], curCost = cur[1], remainK = cur[2];
            if(curP == dst) return curCost;
            if(curCost > distance[curP][remainK]) continue;
            remainK -= 1;
            for(int[] next : graph[curP]){
                int nextP = next[0], nextC = next[1];
                if(remainK < 0) break;
                if(distance[nextP][remainK] > nextC + curCost){
                    distance[nextP][remainK] = nextC + curCost;
                    pq.offer(new int[]{nextP, distance[nextP][remainK], remainK});
                }
            }
        }

        return -1;
    }
}
