class Solution {
    boolean[]visited;
    boolean[]onPath;
    boolean hasCircle = false;;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0 || prerequisites == null || prerequisites.length == 0) return true;
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        
        List<Integer>[] graph = buildUp(prerequisites, numCourses);
        for(int i = 0; i < numCourses; i++){
            dfs(graph, i);
        }

        return !hasCircle;
    }

    public void dfs(List<Integer>[] graph, int start){
        if(onPath[start]){
            hasCircle = true;
            return;
        }

        if(visited[start] || hasCircle) return;
        
        visited[start] = true;
        onPath[start] = true;

        for(int next: graph[start]){
            dfs(graph, next);
        }
        
        onPath[start] = false;
    }


    public List<Integer>[] buildUp(int[][] prerequisites, int numCourses){

        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) graph[i]= new ArrayList<>();
        
        for(int i = 0 ; i < prerequisites.length; i++){  

            int from = prerequisites[i][1];
            int to = prerequisites[i][0];

            graph[from].add(to);
        }

        return graph;
    }
}
