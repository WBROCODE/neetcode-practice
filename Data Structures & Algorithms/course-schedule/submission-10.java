class Solution {
    boolean[] visited;
    boolean[] onPath;
    boolean hasCircle = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] prerequisite : prerequisites){
            int from = prerequisite[1];
            int to = prerequisite[0];
            graph[from].add(to);
        }

        for(int i = 0; i < numCourses; i++){
            dfs(graph, i);
        }

        for(int i = 0; i < numCourses; i++){
            if(!visited[i]) return false;
        }

        return !hasCircle;
    }

    public void dfs(List<Integer>[] graph, int cur){
        if(onPath[cur]){
            hasCircle = true;
            return;
        }
        if (visited[cur] || hasCircle) return;
        visited[cur] = true;
        onPath[cur] = true;
        for(int next : graph[cur]){
            dfs(graph, next);
        }
        onPath[cur] = false;
    }
}
