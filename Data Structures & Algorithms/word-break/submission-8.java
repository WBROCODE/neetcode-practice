class Solution {
    int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        return dp(s, wordDict, 0);
    }

    public boolean dp(String s, List<String> wordDict, int start){
        if(start >= s.length()) return true;
        if(memo[start] != -1) return memo[start] == 1 ? true : false;
        for(String word : wordDict){
            if(start + word.length() > s.length()) continue;
            String sub = s.substring(start, start + word.length());
            if(word.equals(sub)){
                if(dp(s, wordDict, start + word.length())){
                    memo[start] = 1;
                    return true;
                }
            }
        }
        memo[start] = 0;
        return false;
    }
}
