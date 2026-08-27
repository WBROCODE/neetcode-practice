class Solution {
     public int rob(int[] nums) {
        // BU
        int n = nums.length;
        if (n == 1) return nums[0];
        int[]memo1 = new int[n];
        int[]memo2 = new int[n];
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);
        int zeroS = dp(nums, 0, n - 2, memo1);
        int oneS = dp(nums, 1, n - 1,  memo2);
        return Math.max(zeroS, oneS);
    }

    public int dp(int[] nums, int s, int e, int[]memo){
        if(s > e) return 0;
        if(memo[s] != -1) return memo[s];
        int rob = dp(nums, s + 2, e, memo) + nums[s];
        int notR = dp(nums, s + 1, e, memo);
        memo[s] = Math.max(rob, notR);
        return memo[s];
    }
}
