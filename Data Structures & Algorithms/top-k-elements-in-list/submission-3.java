class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /**
        
        map
        K 1 2 3
        V 1 2 3
        
        List<>[] -> n
        int[] ans 

        
        */

        int n = nums.length; 
        Map<Integer, Integer> map = new HashMap<>(); 
        List<Integer>[]tmp = new List[n + 1];

        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            tmp[i + 1] = new ArrayList<>();
        }
        
      
        int[] ans = new int[k];
        for(int key : map.keySet()){
            int val = map.get(key);
            tmp[val].add(key);
        }

        int index = 0;
        for(int i = n; i > 0 && index < k; i--){
            List<Integer> keys = tmp[i];
            
            
                for(int key : keys){
                    ans[index++] = key;
                    if(index == k) return ans;
                }
            

        }


        return ans;
        
    }
}
