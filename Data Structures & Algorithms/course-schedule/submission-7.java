class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildUpGraph(numCourses, prerequisites);

        int[]indegrees = new int[numCourses];

        for(int i = 0; i < graph.length; i++){
            if(graph[i] == null) continue;
            for(int to : graph[i]){
                indegrees[to]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0) queue.offer(i);
        }
        int count = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next : graph[cur]){
                indegrees[next]--;
                if(indegrees[next] == 0){
                    queue.offer(next);
                }
            }
            count++;
        }
        return count == numCourses;
    }

    public  List<Integer>[] buildUpGraph(int n, int[][] edges){
        List<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int from = edge[0], to = edge[1];
            graph[from].add(to);
        }

        return graph;
    }
}
