class Solution {
    int[][] memo;
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        memo = new int[m][n];
        for(int[] arr : memo) Arrays.fill(arr, -1);
        return dp(s, 0, p, 0);
    }

    public boolean dp(String s, int i, String p, int j){
        // base case
        if(j == p.length()){
            return i == s.length();
        }

        if(i == s.length()){
            // check left over
            int leftOver = p.length() - j;
            if(leftOver % 2 == 1) return false;
            // X*Y*B*
            for(int k = j; k < p.length(); k+=2){
                if(p.charAt(k + 1) != '*') return false;
            }
            return true;
        }
        if(memo[i][j] != -1) return memo[i][j] == 1 ? true : false;
        // i == j char
        boolean match = false;
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
            // check j + 1 == '*'
            // aaa          a*a
            if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
                match = dp(s, i + 1, p, j) ||  dp(s, i, p, j + 2); 
            }else{
                match = dp(s, i + 1, p, j + 1);
            }
        }else{
            // a a b    b * a 
            if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
                match = dp(s, i, p, j + 2); 
            }else{
                // a b a        b a a 
               return false;
            }
        }
        memo[i][j] = match ? 1 : 0;

        return match;
    }
}
