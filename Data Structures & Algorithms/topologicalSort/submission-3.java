class Solution {
    
    public List<Integer> topologicalSort(int n, int[][] edges) {
        List<Integer>[] graph = buildUpGraph(n, edges);
        int[] inDegrees = new int[n];

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            inDegrees[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(inDegrees[i] == 0){
                queue.offer(i);
            } 
        }

        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            int cur = queue.poll();
            ans.add(cur);
            for(int next : graph[cur]){
                inDegrees[next]--;
                if(inDegrees[next] == 0){
                    queue.offer(next);
                }
            }
        }
        if(ans.size() != n) return new ArrayList<>();
        return ans;
    }

    public List<Integer>[] buildUpGraph(int n, int[][] edges){
        List<Integer>[] graph = new List[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v= edge[1];
            graph[u].add(v);
        }

        return graph;
    }
}
