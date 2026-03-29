class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /**
        
        map
        K
        V
        
        
        PQ 
        */

        int n = nums.length; 
        Map<Integer, Integer> map = new HashMap<>(); 
        
        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b)->
                Integer.compare(map.get(a), map.get(b))
            
        );
        for(int key :  map.keySet()){
            pq.offer(key);
            if(pq.size() > k) pq.poll();
        }
        int[] ans = new int[k];
        int i = 0;
        while(pq.size() > 0) ans[i++] = pq.poll();
        return ans;
    }
}
