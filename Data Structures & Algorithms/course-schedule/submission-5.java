class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0 || prerequisites == null || prerequisites.length == 0) return true;
        int[]indegrees = new int[numCourses];
        List<Integer>[] graph = buildUp(prerequisites, numCourses);
        for(int i = 0 ; i < prerequisites.length; i++){  
            int to = prerequisites[i][0];
            indegrees[to]++; 
        }

        int canFinish = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i =0; i < numCourses; i++){
            if(indegrees[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()){
            int curCourse = queue.poll();
            canFinish++;
            for(int next : graph[curCourse]){
                indegrees[next]--;
                if(indegrees[next] == 0) queue.offer(next);
            }
        }
        

        return canFinish == numCourses;
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
