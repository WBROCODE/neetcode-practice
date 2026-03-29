class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
         Map<Integer, List<int[]>> graph = new HashMap<>();
        
        for(int i = 1; i <= n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int[] time : times){
            int from = time[0];
            int to = time[1];
            int cost = time[2];
            graph.get(from).add(new int[]{to, cost});
        }

        
        Map<Integer, Integer> shortest= new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);
        pq.offer(new int[]{k, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curTo = cur[0], curCost = cur[1];

            if(shortest.containsKey(curTo)) continue;
            shortest.put(curTo, curCost);
            List<int[]> nexts = graph.get(curTo);

            for(int[]next : nexts){
                int nextTo = next[0], nextCost = next[1];
                if(!shortest.containsKey(nextTo)){
                    pq.offer(new int[]{nextTo, curCost + nextCost});
                }
            }
        }
        if (shortest.size() != n) return -1;
        int ans = 0;
        for(int num : shortest.values()){
            ans = Math.max(num, ans);
        }

        return ans;

    }
}
