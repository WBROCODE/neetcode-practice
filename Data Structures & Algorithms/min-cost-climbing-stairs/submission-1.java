class Solution {
    int[]memo;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return Math.min(dp(cost, n - 1), dp(cost, n - 2));
    }

    public int dp(int[] cost, int start){
        if(start <= 1) return cost[start];

        if(memo[start] != -1) return memo[start];

        memo[start] = Math.min(dp(cost, start - 1), dp(cost, start - 2)) + cost[start];

        return memo[start];
    }

    /**
      0
    1,2,1,2,1,1,1
    


    dp 0 1

    memo 0 dp(0)
    memo 1 dp(0) dp(1)

    n Math.min(dp(n - 1), dp(n - 2))


    */
}
