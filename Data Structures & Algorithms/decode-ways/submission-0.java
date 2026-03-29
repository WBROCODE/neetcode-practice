class Solution {
    int[]memo;
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        if(s.charAt(0) == '0'){
            memo[1] = 0;
        }else memo[1] = 1;

        return dp(s, n);
    }
    // find the way of decode at end
    public int dp(String s, int e){
        if(e > s.length()) return 0;
        if(memo[e] != -1) return memo[e];
        char prevOne = s.charAt(e - 1), prevTwo = s.charAt(e - 2);

        memo[e] = 0;
        // oneDigit
        if(prevOne >= '1' && prevOne <= '9') memo[e] += dp(s, e - 1);
        // twoDigit
        if(prevTwo == '1' || (prevTwo == '2' && prevOne <= '6')) memo[e] += dp(s, e - 2);
        return memo[e];
    }
}
