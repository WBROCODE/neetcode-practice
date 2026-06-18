class HitCounter {
    Deque<Integer> q;
    int limit = 300;
    public HitCounter() {
        q = new ArrayDeque<>();
    }
    
    public void hit(int timestamp) {
        q.offerLast(timestamp);
    }
    
    public int getHits(int timestamp) {

        while(!q.isEmpty()){
            if(timestamp - q.peekFirst() >= 300){
                q.pollFirst();
            } else {
                break;
            }
        }

        return q.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
