class KthLargest {
    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>((a,b)->a-b);
        for(int n : nums){
            pq.offer(n);
        }
    }
    
    public int add(int val) {
        pq.offer(val);

        while(pq.size() > k){
            pq.poll();
        }

        return pq.peek();
    }
}
