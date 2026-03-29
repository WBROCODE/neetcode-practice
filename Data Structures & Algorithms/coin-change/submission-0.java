class Solution {
    public int coinChange(int[] coins, int amount) {
        /**
        dp->min to exchange
        
        dp(coins, a)
        
        1 2 

        2 2

        3 

                0 1 2 3 4 5 6 7 8 9 10 11 12 13
                0 1 2 3 4 1 2 3 4 5 1  2  3    
        */    
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for(int i = 1; i < dp.length; i++){
            for(int coin : coins){
                if(i - coin < 0) continue;
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}
