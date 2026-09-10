class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int m = s.length();

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        boolean[] visited = new boolean[m + 1];
        visited[0] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(String word : wordDict){
                int len = word.length();  
                if(cur + len > m) continue;
                if(visited[cur + len]) continue; 
                if(s.substring(cur, cur + len).equals(word)){
                    q.offer(cur + len);
                    visited[cur + len] = true;
                }
            }
        }
        return visited[m];
    }
}
