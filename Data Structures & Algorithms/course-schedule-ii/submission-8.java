class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int cur = q.poll();
            ans.add(cur);
            for(int next : graph[cur]){
                inDegrees[next]--;
                if(inDegrees[next] == 0){
                    q.offer(next);
                }
            }
        }
        if(ans.size() < numCourses) return new int[]{};
        // count
        int[]res = new int[ans.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = ans.get(i);
        }

        return res;
    }
}
