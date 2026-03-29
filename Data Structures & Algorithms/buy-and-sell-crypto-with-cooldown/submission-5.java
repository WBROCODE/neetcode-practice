class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // cooldown = 1
        int cooldown = 1 + 1;
        int[][] dp = new int[n + cooldown][2];
        for(int i = 0; i < cooldown; i++){
            dp[i][0] = 0;
            dp[i][1] =Integer.MIN_VALUE;
        }
        
        for (int i = cooldown; i < n + cooldown; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i-cooldown]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-cooldown][0] - prices[i-cooldown]);
        }
        return dp[n + cooldown - 1][0];
    }
}
