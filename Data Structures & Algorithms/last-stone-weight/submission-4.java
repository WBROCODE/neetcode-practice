class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones == null || stones.length == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        
        for(int s : stones){
            pq.offer(s);
        }

        while(pq.size() > 1){
            int one = pq.poll();
            int two = pq.poll();
            if(one == two) continue;
            int newS = one - two;
            pq.offer(newS);
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
