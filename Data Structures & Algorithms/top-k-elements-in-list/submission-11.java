class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> map.get(a) - map.get(b));
        // 1 2 3 
        for(int num : map.keySet()){
            pq.add(num);
            while(pq.size() > k){
                pq.poll();
            }
        }

        int[] ans = new int[k];
        int index = 0;
        while(!pq.isEmpty()){
            ans[index++] = pq.poll();
        }

        return ans;
    }
}
