class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int from = edge[0], to = edge[1];
            graph[from].add(to);
            graph[to].add(from);
        }
        
        int ans = 0;
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                bfs(visited, graph, i);
                ans++;
            }
        }   
        
        return ans;
    }

    public void bfs(boolean[] visited, List<Integer>[] graph, int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next : graph[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
