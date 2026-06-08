class Solution {
    
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;
        List<Integer>[] graph = new ArrayList[n];
        for(int i =0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int from  = edge[0], to = edge[1];
            graph[from].add(to);
            graph[to].add(from);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : graph[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]) return false;
        }

        return true;
    }

    
}
