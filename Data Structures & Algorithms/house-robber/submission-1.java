class Solution {
    int[]memo;
    public int rob(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        return dp(nums, n - 1);
    }

    public int dp(int[]nums, int start){
        if(start < 0) return 0;

        if(memo[start] != -1) return memo[start];

        // rob first

        int r = dp(nums, start - 2) + nums[start];

        // rob second

        int notR = dp(nums, start - 1);

        memo[start] = Math.max(r, notR);

        return memo[start];
    }
}
