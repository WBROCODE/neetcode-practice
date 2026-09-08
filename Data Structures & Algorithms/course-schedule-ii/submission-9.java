class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];

        List<Integer>[] graph = new List[numCourses];

        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        int[] indegrees = new int[numCourses];
        for(int[] p : prerequisites){
            graph[p[1]].add(p[0]);
            indegrees[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0) q.offer(i);
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int cur = q.poll();
            ans.add(cur);
            for(int next : graph[cur]){
                indegrees[next]--;
                if(indegrees[next] == 0){
                    q.offer(next);
                }
            }
        }
        if(ans.size() != numCourses) return new int[]{};
        for(int i = 0; i < ans.size(); i++){
            res[i] = ans.get(i);
        }

        return res;
    }
}
