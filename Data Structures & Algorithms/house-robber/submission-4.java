class Solution {
    // up down
    int[]memo;
    public int rob(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        return dp(nums, n - 1);
    }

    public int dp(int[] nums, int end){
        if(end < 0) return 0;
        if(memo[end] != -1) return memo[end];

        memo[end] = Math.max(dp(nums, end - 2) + nums[end], dp(nums, end - 1)) ;

        return memo[end]; 

    }
}
