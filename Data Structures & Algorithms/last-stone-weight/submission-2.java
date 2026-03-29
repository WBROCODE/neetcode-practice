class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq= new PriorityQueue<>((a, b) -> b - a);
        for(int stone : stones) pq.offer(stone);
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();;
            int newStone = Math.abs(a - b);
            if(newStone != 0) pq.offer(newStone);
        }
        
        return pq.isEmpty() ? 0 : pq.peek();


    }
}
