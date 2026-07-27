class Solution {
    List<String> wordDict;
    int[]memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        return dp(s, 0);
    }

    public boolean dp(String s, int start){
        if(start >= s.length()) return true;

        if(memo[start] != -1) return memo[start] == 1 ? true : false;

        for(String word : wordDict){
            if(word.length() + start > s.length()) continue;
            String sub = s.substring(start, start + word.length());
            if(sub.equals(word)){
                if(dp(s, start + word.length())){
                    memo[start] = 1;
                    return true;
                }
            }
        }
        memo[start] = 0;
        return false;
    }
}
