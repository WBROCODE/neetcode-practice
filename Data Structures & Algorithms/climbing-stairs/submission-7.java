class Solution {
    int[]memo;
    public int climbStairs(int n) {
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

    /**
    
    1 + 1
    2 + 1
    
    1 + 1 + 1
    1 + 2 + 1
    2 + 1 + 1
    
    */
}
