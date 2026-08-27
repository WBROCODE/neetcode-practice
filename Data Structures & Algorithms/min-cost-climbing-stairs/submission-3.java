class Solution {
    int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        /**
            dp(0) = csot(0)
            dp(1) = min cost(0), cost(1)
            dp(2) = min(dp(0) + cost(2), dp(1) + cost(2);
            dp(3) = dp()
        */
        int n = cost.length;
        memo = new int[n];
        Arrays.fill(memo, -1);

        return Math.min(dp(cost, n - 1), dp(cost, n - 2));
    }

    public int dp(int[]cost, int start){
        if(start == 0) return cost[0];
        if(start == 1) return cost[1];
        if(memo[start] != -1) return memo[start];
        memo[start] = Math.min(dp(cost, start - 1), dp(cost, start - 2)) + cost[start];
        return memo[start];
    }
}
