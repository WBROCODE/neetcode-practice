class Solution {
    int[] memo;
    public int numDecodings(String s) {
        /**
                0 -> 0
                1 -> 1
        
                    prevT    prevO    
                      1        2
        
                1-9 

                1       || 2 1-6    
                dp(e - 1) + dp(e - 2)


        */
        int n = s.length();
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        if(s.charAt(0) == '0') memo[1] = 0;
        else memo[1] = 1;
        return dp(s, n);
    }

    public int dp(String str, int s){
        if(s < 0) return 0;
        if(memo[s] != -1) return memo[s];
        char prevO = str.charAt(s - 1), prevT = str.charAt(s - 2);
        memo[s] = 0;
        if(prevO >= '1' && prevO <= '9') memo[s] += dp(str, s - 1);
        if(prevT == '1' || (prevT == '2' && prevO >= '0' && prevO <= '6')) memo[s] += dp(str, s - 2);

        return memo[s];
    }


}
