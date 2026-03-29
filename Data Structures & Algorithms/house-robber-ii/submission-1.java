class Solution {
    public int rob(int[] nums) {
        /**
        0 1 2  3 4 5
        3,4,3，3,4,3
          1       n-1

        0       n-2
        */
        int n = nums.length;
        if (n == 1) return nums[0];
        int[]memo1 = new int[n];
        int[]memo2 = new int[n];
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);
        
        int one = dp(n - 2, 0, nums, memo1);
        int two = dp(n - 1, 1, nums, memo2);

        return Math.max(one, two);
    }

    public int dp(int start, int end, int[]nums, int[] memo){
        if(start < end) return 0;

        if(memo[start] != -1) return memo[start];

        int rob = dp(start - 2, end, nums, memo) + nums[start];
        int notR = dp(start - 1, end, nums, memo);

        memo[start] = Math.max(rob, notR);
        return memo[start];
    }
}
