class Solution {
    public boolean canPartition(int[] nums) {
        // backpack
        int sum = 0;
        for(int n : nums) sum += n;
        if(sum % 2 == 1) return false;
        sum /= 2;
        // put it in or not
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];

         for(boolean[] next : dp) next[0] = true;

        for(int i = 1; i <= nums.length; i++){
            for(int j = 1; j <= sum; j++){
                if(j - nums[i - 1] < 0){
                    // can't put it in
                    dp[i][j] = dp[i - 1][j];
                }else{
                    // put it in or not
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][sum];
    }
}
