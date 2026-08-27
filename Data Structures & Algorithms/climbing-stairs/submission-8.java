class Solution {
    int[] memo;
    public int climbStairs(int n) {
        /**
            dp(0) = 0;
            dp(1) = 1
            dp(2) = 2
            dp(3) = dp(2) + 1 = 3 
            dp(n) = dp(n - 1) + dp(n - 2)
        */

        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dp(n);
    }

    public int dp(int n){
        if(n <= 2) return n;
        if(memo[n] != -1) return memo[n];
        memo[n] = dp(n - 1) + dp(n - 2);
        return memo[n];
    }
}
