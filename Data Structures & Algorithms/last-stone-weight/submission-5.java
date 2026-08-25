class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b - a);
        for(int s : stones){
            pq.offer(s);
        }

        while(pq.size() > 1){
            int one = pq.poll();
            int two = pq.poll();
            if(one == two) continue;
            else if(one > two){
                pq.offer(one - two);
            }else{
                pq.offer(two - one);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
