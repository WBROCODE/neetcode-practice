class Solution {
    int[]memo;
    public int rob(int[] nums) {
        // buttom up
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        return dp(nums, 0);
    }

    public int dp(int[]nums, int start){
        if(start >= nums.length) return 0;

        if(memo[start] != -1) return memo[start];

        // rob first
        int r = dp(nums, start + 2) + nums[start];

        // rob second

        int notR = dp(nums, start + 1);

        memo[start] = Math.max(r, notR);

        return memo[start];
    }
}
