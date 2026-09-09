class Solution {
    int[] memo;
    public int climbStairs(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dp(n, n);
    }

    public int dp(int n, int s){
        if(s <= 2) return s;
        if(memo[s] != -1) return memo[s];

        memo[s] = dp(n, s - 1) + dp(n, s - 2);

        return memo[s]; 
    }
}
