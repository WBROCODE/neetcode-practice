class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int[] memoOne = new int[n];
        int[] memoTwo = new int[n];
        Arrays.fill(memoOne, -1);
        Arrays.fill(memoTwo, -1);

        return Math.max(dp(nums, 1, n - 1, memoOne), dp(nums, 0, n - 2, memoTwo));
    }

    public int dp(int[] nums, int start, int end, int[]memo){
        if(start > end) return 0;
        if(memo[start] != -1) return memo[start];

        memo[start] = Math.max(dp(nums, start + 2, end, memo) + nums[start], dp(nums, start + 1, end, memo)) ;

        return memo[start]; 

    }
}
