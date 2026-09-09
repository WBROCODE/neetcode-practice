class Solution {
    int[] memo;
    public int rob(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        /**
            R:dp[i][0] = max(dp[i - 1][1], dp[i - 2][0] + nums[i])
            N:dp[i][1] = max(dp[i- 1][0] + nums[i - 1], dp[i - 2][1])
        */

        return dp(n - 1, nums);
    }

    public int dp(int start, int[]nums){
        if(start == 0) return nums[0];
        if(start == 1) return Math.max(nums[0], nums[1]);
        if(memo[start] != -1) return memo[start];

        memo[start] = Math.max(dp(start - 1, nums), dp(start - 2, nums) + nums[start]);

        return memo[start];
    }
}
