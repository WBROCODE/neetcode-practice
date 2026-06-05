class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();

        for(int num : nums) set.add(num);
        int ans = 1;
        for(int s : set){
            if(set.contains(s - 1)){
                int len = 1;
                while(set.contains(s - 1 + len)){
                    len++;
                }
                ans = Math.max(ans, len);
            }
        }

        return ans;
    }
}
