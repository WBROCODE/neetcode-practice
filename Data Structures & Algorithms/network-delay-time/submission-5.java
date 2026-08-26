class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // build weighted graph
        // count inDegree
        // Dj

        List<int[]>[] graph = new ArrayList[n + 1];

        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] t : times){
            int from = t[0], to = t[1], cost = t[2];
            graph[from].add(new int[]{to, cost});
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);
        pq.offer(new int[]{k, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curP = cur[0], curCost = cur[1];
            if(curCost > distance[curP]) continue;
            distance[curP] = curCost;
            for(int[] next : graph[curP]){
                int nextP = next[0], nextC = next[1];
                if(distance[nextP] > curCost + nextC) {
                    distance[nextP] = nextC + curCost;
                    pq.offer(new int[]{nextP, distance[nextP]});
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            if(distance[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(distance[i], ans);
        }

        return ans;
    }
}
