class Solution {
     public int[] findOrder(int numCourses, int[][] prerequisites) {
        // if(numCourses == 0 || prerequisites == null || prerequisites.length == 0) return new int[]{};

        List<Integer>[] graph = buildUpGraph(numCourses, prerequisites);

        List<Integer> ans = new ArrayList<>();

        int[]indegree = new int[numCourses];

        // indegree
        for(int[]prerequisite : prerequisites){
            int to = prerequisite[0];
            indegree[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int curCourse = queue.poll();
            ans.add(curCourse);
            for(int next : graph[curCourse]){
                indegree[next]--;
                if(indegree[next] == 0){
                    queue.offer(next);
                   
                }
            }
        }

        if(ans.size() != numCourses) return new int[]{};
        int[]res = new int[ans.size()];
        for(int j = 0; j < ans.size(); j++){
            res[j] = ans.get(j);
        }
        return res;
    }

    public List<Integer>[] buildUpGraph(int n, int[][] edges){
        List<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[]edge : edges){
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }
}
