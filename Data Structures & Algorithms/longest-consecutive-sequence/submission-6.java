class Solution {
    public int longestConsecutive(int[] nums) {
        /**
        2,20,4,10,3,4,5
        
        */
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int n : nums) set.add(n);
        int ans = 1;
        for(int n : set){
            if(set.contains(n - 1)){
                int len = 1;
                while(set.contains(n - 1 + len)){
                    len++;
                }
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }
}
