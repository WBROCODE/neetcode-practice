class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] time : times){
            int from = time[0], to = time[1], cost = time[2];
            graph[from].add(new int[]{to, cost});
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{k, 0});
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int to = cur[0], cost = cur[1];
            if(cost > distance[to]) continue;

            for(int[] next : graph[to]){
                int nextTo = next[0];
                int nextCost = next[1];
                if(cost + nextCost < distance[nextTo]){
                    distance[nextTo] = cost + nextCost;
                    q.offer(new int[]{nextTo,  distance[nextTo]});
                }
            }
        }
        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(distance[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, distance[i]);
        }

        return ans;
    }
}
