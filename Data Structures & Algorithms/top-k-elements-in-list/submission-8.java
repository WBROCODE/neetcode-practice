class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /**
        

        1,2,2,3,3,3

        map

        freq < n

        List[]freqs
        
        3 - 3
        2 - 3

        3,2

        */

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List[] freqs = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            freqs[i] = new ArrayList<>();
        }

        for(int key : map.keySet()){
            int freq = map.get(key);
            freqs[freq].add(key);
        }
        int[]ans = new int[k];
        int j = k - 1;
        for(int i = n; i >= 0 && j >= 0; i--){
            List<Integer> freq = freqs[i];
            for(int f : freq){
                ans[j--] = f;
            }
        }
        return ans;
    }
}
