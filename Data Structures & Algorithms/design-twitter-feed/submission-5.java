class Twitter {
    Map<Integer, List<int[]>> newsMap;
    Map<Integer, Set<Integer>> followMap;
    int time = 0;
    public Twitter() {
        newsMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(newsMap.containsKey(userId)){
            newsMap.get(userId).add(new int[]{time++, tweetId});
        }else{
            newsMap.putIfAbsent(userId, new ArrayList<>());
            newsMap.get(userId).add(new int[]{time++, tweetId});
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[0] - a[0]));
            List<int[]> news = newsMap.getOrDefault(userId, new ArrayList<>());
            for(int[] n : news){
                pq.offer(n);
            }
            
            Set<Integer> following = followMap.getOrDefault(userId, new HashSet<>());
            for(int f : following){
                if(newsMap.containsKey(f)){
                    if(newsMap.get(f) != null){
                        for(int[] fNews : newsMap.get(f)){
                            pq.offer(fNews);
                        }
                    }
                }
            }

            List<Integer> ans = new ArrayList<>();
            while(!pq.isEmpty() && ans.size() < 10){
                ans.add(pq.poll()[1]);
            }
            return ans;
        
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).add(followeeId);
        }else{
            followMap.computeIfAbsent(followerId, k->new HashSet<>()).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}
