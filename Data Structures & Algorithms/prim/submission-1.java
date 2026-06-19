class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        boolean[]visited = new boolean[n];
        List<List<int[]>> graph = buildUpGraph(n, edges);
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->a[1] - b[1]
        );
        int ans = 0;
        pq.offer(new int[]{0, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curS = cur[0], cost = cur[1];
            if(visited[curS]) continue;
            visited[curS] = true;
            ans += cost;
            for(int[] next : graph.get(curS)){
                pq.offer(next);
            }
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]) return -1;
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
            graph.get(to).add(new int[]{from, weight});
        }

        return graph;
    }
}    
