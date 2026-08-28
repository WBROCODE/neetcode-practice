class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;    
        if(sum % 2 == 1) return false;
        boolean[] dp = new boolean[sum + 1];
        sum /= 2;
        dp[0] = true;
        /**
        
        
            num : nums

            sum 

             || sum - num   

        */   

        for(int num : nums){
            for(int i = sum; i >= num; i--){
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[sum];
    }
}
