class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int len = 0;
        int start = 0;
        for(int i = 0; i < n ; i++){
            for(int j = i; j >= 0; j--){
                if(s.charAt(i) == s.charAt(j)){
                    if(i - j + 1 < 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i - 1][j + 1];
                    }
                }
                if(dp[i][j] && i - j + 1 > len){
                    len = i - j + 1;
                    start = j;
                }
            }
        }
        
        return s.substring(start, start + len);

    }
}
