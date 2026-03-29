class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] inDegrees = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] prerequisite : prerequisites){
            int from = prerequisite[1];
            int to = prerequisite[0];
            graph[from].add(to);
            inDegrees[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < inDegrees.length; i++){
            if(inDegrees[i] == 0){
                q.offer(i);
            }
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


}
