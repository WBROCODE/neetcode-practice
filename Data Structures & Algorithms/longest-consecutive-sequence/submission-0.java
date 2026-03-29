class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        int ans = 0;
        for(int i =0 ; i < nums.length; i++){

            if(!set.contains(nums[i] - 1)){
                int len = 0;
                int start = nums[i];
                while(set.contains(start)){
                    len++;
                    start++;
                }
                ans =Math.max(ans, len);
            }

        }
        return ans;
    }
}
