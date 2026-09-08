class Solution {
    public int lengthOfLIS(int[] nums) {
        // DP
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = 0; i < n; i++){
            for(int j = i; j >= 0; j--){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int len = 1;
        for(int d : dp) len = Math.max(len, d);

        return len;
    }
}
