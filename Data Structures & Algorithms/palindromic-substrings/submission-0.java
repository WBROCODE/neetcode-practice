class Solution {
    public int countSubstrings(String s) {
        /**       
            a b a b d
            i      
                j 
        
            i == j
            j - i < 3
            dp[i][j]
            i - 1 j + 1
        */
        int n = s.length();
        // whether is Palindro
        int ans = 0;
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = i; j >= 0; j--){
                if(s.charAt(i) == s.charAt(j)){
                    if(i - j < 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i - 1][j + 1];
                    }
                }
                if(dp[i][j]) ans++;
            }

        }
        return ans;
    }
}
