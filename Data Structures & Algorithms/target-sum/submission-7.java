class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums) sum+=num;
        /**
            subset: 
            a + a - b = target + a
            a = (target + total) / 2
        */ 
       
        if(Math.abs(target) > sum || (target + sum) % 2 == 1) return 0;
         int aim = (target + sum) / 2;
        int n = nums.length;
        int[][] dp = new int[n + 1][aim + 1];
        dp[0][0] = 1;

        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= aim; j++){
                if(j - nums[i - 1] >= 0){
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][aim];
    }


}
