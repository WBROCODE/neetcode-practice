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
        int[] dp = new int[aim + 1];
        
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = aim; j >= 0; j--){
                if(j - nums[i - 1] >= 0){
                    dp[j] = dp[j] + dp[j - nums[i - 1]];
                }else{
                    dp[j] = dp[j];
                }
            }
        }

        return dp[aim];
    }


}
