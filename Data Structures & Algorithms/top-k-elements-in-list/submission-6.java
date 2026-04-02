class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /**
            BUCKET SORT

            List[] freqs 
                 |
            k
            SC:N TC:N
        */
        if(k > nums.length) return new int[]{};
        int n = nums.length;
        List[] freqs = new ArrayList[n + 1];

        for(int i = 0; i <= n; i++){
            freqs[i] = new ArrayList<>();
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int key : map.keySet()){
            int freq = map.get(key);
            freqs[freq].add(key);
        }
        int[] ans = new int[k];
        int index = 0;
        for(int i = n; i >= 0 && index < k; i--){
            List<Integer> topElement = freqs[i];
            for(int e : topElement){
                ans[index++] = e;
            }
        }
        return ans;
    }
}
