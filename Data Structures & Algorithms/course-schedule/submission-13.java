class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildUp(numCourses, prerequisites);

        int[]inDegrees = new int[numCourses];
        for(int[] next : prerequisites){
            int from = next[1];
            int to = next[0];
            inDegrees[to]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegrees[i] == 0) q.offer(i);
        }
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

        return count == numCourses;

    }

    public List<Integer>[] buildUp(int n, int[][] prerequisites){
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] next : prerequisites){
            int from = next[1];
            int to = next[0];
            graph[from].add(to);
        }
        return graph;
    }

}
