class Solution {
    List<Integer> ans;
    boolean[] visited;
    boolean[] onPath;
    boolean hasCircle;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        ans = new ArrayList<>();
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] prerequisite : prerequisites){
            int from = prerequisite[1], to = prerequisite[0];
            graph[from].add(to);
        }

        for(int i = 0; i < numCourses; i++){
            dfs(graph, i);
        }

        if(hasCircle) return new int[]{};

        for(int i = 0; i < numCourses; i++){
           if(!visited[i]) return new int[]{};
        }

        Collections.reverse(ans);
        int[]res = new int[ans.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = ans.get(i);
        }

        return res;
    }

    public void dfs(List<Integer>[] graph, int cur){
        if(onPath[cur]){
            hasCircle = true;
            return;
        }
        if(onPath[cur] || visited[cur]) return;

        onPath[cur] = true;
        visited[cur] = true;
        for(int next : graph[cur]){
            dfs(graph, next);
        }
        ans.add(cur);
        onPath[cur] = false;

    }
}
