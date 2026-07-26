class Solution {
     int[]memo;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return Math.min(dp(cost, n - 1), dp(cost, n - 2));
    }

    public int dp(int[] cost, int n){
        if(n < 2) return cost[n];

        if(memo[n] != -1) return memo[n];

        memo[n] = Math.min(dp(cost, n - 1), dp(cost, n - 2)) + cost[n];
        
        return memo[n];
    }
}
