class Solution {
    public String longestPalindrome(String s) {
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
        int start = 0, len = 0;
        // whether is Palindro
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
                if(i - j + 1 > len && dp[i][j]){
                    len = i - j + 1;
                    start = j;
                }
            }

        }
        return s.substring(start, start + len);
    }
}
