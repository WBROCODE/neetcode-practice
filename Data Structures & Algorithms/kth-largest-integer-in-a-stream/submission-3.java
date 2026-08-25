class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>((a,b)->a - b);
        for(int n : nums){
            pq.offer(n);
            if(pq.size() > k){
                pq.poll();
            }
        }
        this.k = k;
    }
    
    public int add(int val) {
        pq.offer(val);
        while(pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
}
