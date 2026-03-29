class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;
        List<Integer>[] graph = buildUpGraph( n,  edges);
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;    

        while(!q.isEmpty()){
            int size = q.size();
            
                int curNode = q.poll();
                for(int next : graph[curNode]){
                    if(!visited[next]){
                        q.offer(next);
                        visited[next] = true;
                    }
                }
            
        }

        for(boolean visit : visited) if(visit == false) return false;
        return true;
    }

    public List<Integer>[] buildUpGraph(int n, int[][] edges){
        List<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int from = edge[0], to = edge[1];
            graph[from].add(to);
            graph[to].add(from);
        }
        return graph;
    }
}
