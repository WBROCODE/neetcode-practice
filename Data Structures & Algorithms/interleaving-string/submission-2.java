class Solution {
    int[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if(m + n != s3.length()) return false;
        memo = new int[m + 1][n + 1];
        for(int[]row : memo){
            Arrays.fill(row, -1);
        }
        return dp(s1, s2, s3, 0, 0);
    }
    /**
    s3

    i + j = len
    
    aaaa                bbbb
    i                   j

    aa bbbb aa
    p
    i = p
    dp[i][j] = dp[i + 1][j]
    j = p
    dp[i][j] || dp[i][j + 1]
    
    */

    public boolean dp(String s1, String s2, String s3, int i, int j){
        int p = i + j;
        if(p == s3.length()){
            return true;
        }

        if(memo[i][j] != -1) return memo[i][j] == 1;

        boolean ans = false;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(p)){
            ans = dp(s1, s2, s3, i + 1, j);
        }

        if(j < s2.length() && s2.charAt(j) == s3.charAt(p)){
            ans |= dp(s1, s2, s3, i, j + 1);
        }
        
        memo[i][j] = ans ? 1 : 0;
        
        return ans;
    }


}
