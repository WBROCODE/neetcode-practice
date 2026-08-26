class Twitter {
    Map<Integer, PriorityQueue<int[]>> posts;
    Map<Integer, HashSet<Integer>> following;
    int time = 0;
    public Twitter() {
        posts = new HashMap<>();
        following = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        // posts -> add {time, tweetId}
        // max -> min
        posts.computeIfAbsent(userId, k-> new PriorityQueue<>((a,b)->b[0] - a[0])).offer(new int[]{time, tweetId});
        time++;
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // get follower
        HashSet<Integer> follows = following.get(userId);
        // get tweets
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> temp = new PriorityQueue<>((a,b)->b[0] - a[0]);
        if(follows != null){
            for(int user : follows){
                if(!posts.containsKey(user)) continue;
                PriorityQueue<int[]> post = posts.get(user);
                if(post.isEmpty()) continue;
                int time = 10;
                PriorityQueue<int[]> cur = new PriorityQueue<>(post);
                while(time > 0){
                    if(cur.isEmpty()) break;
                    temp.offer(cur.poll());
                    time--;
                }
            }
        }
        // add itself
        PriorityQueue<int[]> itself = posts.get(userId);
        if(itself != null){
            int time = 10;
            PriorityQueue<int[]> now = new PriorityQueue<>(itself);
            while(time > 0){
                if(now.isEmpty()) break;
                temp.offer(now.poll());
                time--;
            }
        }
        
        // get 10
        int count = 10;
        while(count > 0){
            if(temp.isEmpty()) break;
            ans.add(temp.poll()[1]);
            count--;
        }
        // sort 
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        // following add
        if(followerId == followeeId) return;
        following.computeIfAbsent(followerId, k-> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        // remove
        if(!following.containsKey(followerId)) return;
        HashSet<Integer> follows = following.get(followerId);
        if(!follows.contains(followeeId)) return;
        follows.remove(followeeId);
        following.put(followerId, follows);
    }
}
