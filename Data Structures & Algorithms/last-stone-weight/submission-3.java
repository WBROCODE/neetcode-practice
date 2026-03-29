class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for(int stone : stones) pq.offer(stone);

        while(pq.size() > 1){
            int one = pq.poll();
            int two = pq.poll();
            if(one == two) continue;
            int newS = one - two;
            pq.offer(newS);
        }
        return pq.isEmpty() ?  0 : pq.peek();
    }
}
