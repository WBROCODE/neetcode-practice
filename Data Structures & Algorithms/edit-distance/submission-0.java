class Solution {
    int[][]memo;
    public int minDistance(String word1, String word2) {
        memo = new int[word1.length() + 1][word2.length() + 1];

        for(int[] m : memo) Arrays.fill(m, -1);

        return dp(word1, 0, word2, 0);
    }

    public int dp(String word1, int i, String word2, int j){
        if(i == word1.length()) return word2.length() - j;
        if(j == word2.length()) return word1.length() - i;
        
        if(memo[i][j] != -1) return memo[i][j];

        if(word1.charAt(i) == word2.charAt(j)){
            memo[i][j] = dp(word1, i + 1, word2, j + 1);
        }else{
            // insect
            int insect = dp(word1, i, word2, j + 1);
            // delete
            int delete = dp(word1, i + 1, word2, j);
            // change
            int change = dp(word1, i + 1, word2, j + 1);

            memo[i][j] = 1 + Math.min(Math.min(insect, delete), change);
        }
        return memo[i][j];
    }
}
