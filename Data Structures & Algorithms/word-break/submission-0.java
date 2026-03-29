class Solution {
    int[]memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dp(s, wordDict, 0);
    }

    public boolean dp(String s, List<String> wordDict, int e){
        int n = s.length();
        if(e == n) return true;
        if(memo[e] != -1) return memo[e] == 1 ? true : false;
        for(String word : wordDict){
            int len = word.length();
            if(e + len > n) continue;

            if(s.substring(e, e + len).equals(word)){
                if(dp(s, wordDict, e + len)){
                    memo[e] = 1;
                    return true;
                }
            }
        }
        memo[e] = 0;
        return false;
    }
}
