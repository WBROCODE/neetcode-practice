class Solution {
    int[][]memo;
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        memo = new int[n][n];
        for(int[] m : memo) Arrays.fill(m, -1);

        return dp(s, 0, n - 1);
    }

    public int dp(String s, int l, int r){
        if(l > r) return 0;
        if(l == r) return 1;

        if(memo[l][r] != -1) return memo[l][r] ;
        if(s.charAt(l) == s.charAt(r)){
            memo[l][r]  = dp(s, l + 1, r - 1) + 2;
        }else{
            memo[l][r] = Math.max(dp(s, l + 1, r),  dp(s, l, r - 1));
        }

        return memo[l][r];
    }
}