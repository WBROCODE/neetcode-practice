class Solution {
    int[]memo;
    public int rob(int[] nums) {
        /**
            dp(0) = nums[0]
            dp(1) = Math.max(nums[1], nums[0])
            dp(2) = Math.max(dp(0), dp(1)) + nums[1]
        */
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, nums.length - 1);
    }

    public int dp(int[] nums, int s){
        if(s == 0) return nums[0];
        if(s == 1) return Math.max(nums[0], nums[1]);
        if(memo[s] != -1) return memo[s];
        memo[s] = Math.max(dp(nums, s - 1), dp(nums, s - 2) + nums[s]);

        return memo[s];
    }
}
