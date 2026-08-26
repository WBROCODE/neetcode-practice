class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build up graph
        List<Integer>[] graph = new List[numCourses];

        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        // count inDegree
        int[] inDegrees = new int[numCourses];
        for(int[] p : prerequisites){
            int from = p[1], to = p[0];
            graph[from].add(to);
            inDegrees[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegrees[i] == 0) q.offer(i);
        }
        // topo
        int count = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            count++;
            for(int next : graph[cur]){
                inDegrees[next]--;
                if(inDegrees[next] == 0){
                    q.offer(next);
                }
            }
        }
        // count   
        return count == numCourses;
    }
}
