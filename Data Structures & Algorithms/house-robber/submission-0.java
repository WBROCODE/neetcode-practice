class Solution {
    int[]memo;
    public int rob(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo,-1);
        return dp(nums, 0);
    }

    public int dp(int[]nums,int i){
        if(i >= nums.length) return 0;
        if(memo[i] != -1) return memo[i];

        memo[i] = Math.max(dp(nums, i + 1), dp(nums, i + 2) + nums[i]);
        return memo[i];
    }
}
