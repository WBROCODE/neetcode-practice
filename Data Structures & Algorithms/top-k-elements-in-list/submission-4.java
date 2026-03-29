class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqM = new HashMap<>();
        for(int num : nums){
            freqM.put(num, freqM.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b)->{
                int x = freqM.get(a);
                int y = freqM.get(b);
                if(x == y) return a - b;
                return x - y;
            }
        );
        for(int num : freqM.keySet()){
            pq.offer(num);
            if(pq.size() > k) pq.poll();
        }

        int[] ans = new int[pq.size()];
        int i = 0;
        while(!pq.isEmpty()){
            ans[i++] = pq.poll();
        }
        return ans;
    }
}
