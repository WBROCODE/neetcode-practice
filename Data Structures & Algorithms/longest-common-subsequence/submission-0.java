class Solution {
     int[][]memo;
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for(int[] m : memo) Arrays.fill(m, -1);
        return dp(text1, 0, text2, 0);
    }

    public int dp(String w1, int i, String w2, int j){
        if(i == w1.length() || j == w2.length() ) return 0;

        if(memo[i][j] != -1) return memo[i][j];

        if(w1.charAt(i) == w2.charAt(j)){
            memo[i][j] = dp(w1, i + 1, w2, j + 1) + 1;
        }else{
            memo[i][j] = Math.max(dp(w1, i + 1, w2, j), dp(w1, i, w2, j + 1));
        }
        return memo[i][j];
    }
}
