class Solution {
   
     
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[]memo1 = new int[n];
        int[]memo2  = new int[n];
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);
        int zeroS = dp(0, n - 2, nums, memo1);
        int oneS = dp(1, n - 1, nums, memo2);
        return Math.max(zeroS, oneS);
    }

    public int dp(int s, int e, int[] nums, int[]memo){
        if(s > e) return 0;
        if(memo[e] != -1) return memo[e];
        memo[e] = Math.max(dp(s, e - 1, nums, memo), dp(s, e - 2, nums, memo) + nums[e]);
        return memo[e];
    }
}
