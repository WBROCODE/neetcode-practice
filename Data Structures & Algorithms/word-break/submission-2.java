class Solution {
    List<String> wordDict;
    int[]memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        return dp(s, 0);
    }

    public boolean dp(String s, int e){
        if(e == s.length()){
            return true;
        }
        if(memo[e] != -1) return memo[e] == 1 ? true : false;
        for(String word : wordDict){
            int len = word.length();
            if(e + len > s.length()) continue;
            String str = s.substring(e, e + len);
            if(str.equals(word)){
                if(dp(s, e + len)){
                    memo[e] = 1;
                    return true;
                }
            }
        }
        memo[e] = 0;
        return false;
    }
}
