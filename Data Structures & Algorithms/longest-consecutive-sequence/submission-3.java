class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0; 
        Map<Integer, Integer> map=new HashMap<>();


        for(int num : nums){

            if(!map.containsKey(num)){
                map.put(num, map.getOrDefault(num - 1, 0) + map.getOrDefault(num + 1, 0) + 1);
                map.put(num - map.getOrDefault(num - 1, 0), map.get(num));
                map.put(num + map.getOrDefault(num + 1, 0), map.get(num));

                ans = Math.max(ans, map.get(num));
            }

        }

        return ans;
    }
}
