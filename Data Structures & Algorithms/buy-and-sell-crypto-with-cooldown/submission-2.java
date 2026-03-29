class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // cooldown = 1
        int k = 2;
        int[][] dp = new int[n + k][2];
        for(int i = 0; i < k; i++){
            dp[i][0] = 0;
            dp[i][1] =Integer.MIN_VALUE;
        }
        
        for (int i = k; i < n + k; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i-k]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-k][0] - prices[i-k]);
        }
        return dp[n + k - 1][0];
    }
}
