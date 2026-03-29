class Solution {
    public int climbStairs(int n) {
        /**
        1 + 1 
        2 + 0
        

        1 + 1 + 1
        2+ 0 + 1
        2 + 

        */
        memo = new int[n + 1];
        return dp(n);
    }

    int[]memo;

    public int dp(int n){

        if(n <= 2) return n;
        if(memo[n] != 0) return memo[n];
        memo[n] = dp(n - 1) + dp(n - 2);

        return memo[n];
    }
}
