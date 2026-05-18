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
                dfs(visited, graph, i);
                ans++;
            }
        }   
        
        return ans;
    }

    public void dfs(boolean[] visited, List<Integer>[] graph, int start){
        if(visited[start]) return;

        visited[start] = true;
        for(int next : graph[start]){
            dfs(visited, graph, next);
        }

    }
}