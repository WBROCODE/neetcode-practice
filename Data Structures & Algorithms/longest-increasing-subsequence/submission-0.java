class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // nums[i] end biggest
        int[]dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = 0; i < n ; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = 0;
        for(int i : dp) ans = Math.max(ans, i);
        return ans;
    }

}
