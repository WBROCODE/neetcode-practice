class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        List<List<int[]>> graph = buildUpGraph(n, edges);

        Map<Integer, Integer> ans = new HashMap<>();

        int[]distances = new int[n];

        Arrays.fill(distances, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);
        pq.offer(new int[]{src, 0});
        distances[src] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int to = cur[0];
            int curCost = cur[1];
            if(distances[to] < curCost) continue;
            for(int[] next : graph.get(to)){
                int nextTo = next[0];
                int nextCost = next[1];

                if(nextCost + distances[to] < distances[nextTo]){
                    distances[nextTo] = nextCost + distances[to];
                    pq.offer(new int[]{nextTo, distances[nextTo]});
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(distances[i] == Integer.MAX_VALUE) ans.put(i, -1);
            else ans.put(i, distances[i]);
        }
        return ans;
    }  

    public List<List<int[]>> buildUpGraph(int n, List<List<Integer>> edges){
        List<List<int[]>>  graph = new ArrayList<>();
        for(int i =0 ;i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(List<Integer> edge : edges){
            int from = edge.get(0);
            int to = edge.get(1);
            int weight = edge.get(2);
            graph.get(from).add(new int[]{to, weight});
        }

        return graph;
    }
}
