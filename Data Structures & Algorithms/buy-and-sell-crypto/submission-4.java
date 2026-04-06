class Solution {
    public int maxProfit(int[] prices) {
        // SC & TC : N
        int n = prices.length;
        int[][]dp = new int[n][2];
        // keep
        dp[0][1] = -prices[0];
        // sell 
        dp[0][0] = 0;
        int ans = 0;
        for(int i = 1; i < n; i++){
            // sell
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // keep 
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            ans = Math.max(ans, dp[i][0]);
        }

        return ans;
    }
}
