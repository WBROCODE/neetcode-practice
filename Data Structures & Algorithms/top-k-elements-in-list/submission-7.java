class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /**

        1,2,2,3,3,3
        
        N * logK

        */
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b)->{
                return map.get(a) - map.get(b);
            }
        );
        for(int num : map.keySet()){
            pq.offer(num);
            if(pq.size() > k) pq.poll();
        }
        int[]ans = new int[k];
        int i = 0;
        while(!pq.isEmpty()){
            ans[i++] = pq.poll();
        }

        return ans;
    }
}
