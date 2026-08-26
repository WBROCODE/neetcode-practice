class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;
         // build up graph
        List<Integer>[] graph = new List[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] p : edges){
            int from = p[1], to = p[0];
            graph[from].add(to);
            graph[to].add(from);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        // topo
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            visited[cur] = true;
            for(int next : graph[cur]){
                if(!visited[next]){
                    q.offer(next);
                }
            }
        }
        for(boolean t : visited){
            if(t == false) return false;
        }
        return true;
    }
}
