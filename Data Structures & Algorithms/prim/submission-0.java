class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        List<List<int[]>> graph = buildUpGraph(n, edges);
        int ans = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[1] - b[1]
        );

        pq.offer(new int[]{0, 0});
        int count = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int to = cur[0];
            int curCost = cur[1];
            if(visited[to]) continue;
            visited[to] = true;
            ans+=curCost;
            count++;

            for(int[] next : graph.get(to)){
                int nextTo = next[0];
                int nextCost = next[1];
                if(!visited[nextTo]){
                    pq.offer(next);
                }
            }
        }
        return count == n ? ans : -1;
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
            graph.get(to).add(new int[]{from, weight});
        }

        return graph;
    }
}    
