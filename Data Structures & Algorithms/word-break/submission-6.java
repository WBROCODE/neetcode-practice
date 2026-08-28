class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        /**
        
            M


            for() N

        
        */
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int m = s.length(), n = wordDict.size();
        boolean[] visited = new boolean[m + 1];
        visited[0] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(String word : wordDict){
                int len = word.length();
                if(cur + len > m) continue;
                if(visited[cur + len]) continue;
                if(s.substring(cur, cur + len).equals(word)){
                    if(cur + len == m) return true;
                    visited[cur + len] = true;
                    q.offer(cur + len);
                }
            }
        }
        return false;

    }
}
