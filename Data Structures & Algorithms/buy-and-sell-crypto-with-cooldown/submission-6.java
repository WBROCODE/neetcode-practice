class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int coolDown = 2;
        int[][] dp = new int[n + coolDown][2];

        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[1][0] = 0;
        dp[1][1] = Integer.MIN_VALUE;



        for(int i = 2; i < n + coolDown; i++){
            // sell
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 2]);
            // buy
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i - 2]);
        }
        return dp[n + 1][0];
    }
}
