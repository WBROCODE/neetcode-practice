class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // bucket sort

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int n = nums.length;

        List<Integer>[] bucket = new List[n + 1];

        for(int key : frequencyMap.keySet()){
            int freq = frequencyMap.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int[] ans = new int[k];
        int index = k - 1;
        for(int i = bucket.length - 1; i >= 0 && index >= 0; i--){
            List<Integer> temp = bucket[i];
            if(temp == null) continue; 
            for(int num : temp){
                ans[index--] = num;
            }
        }
        return ans;
    }
}
