class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0 , r = 0, ans = 0;

        int[]count = new int[128];
        int maxF = 0;
        while(r < n){
            char chR = s.charAt(r);
            count[chR]++;
            maxF = Math.max(maxF, count[chR]);
            while(r - l + 1  - maxF > k){
                char chL = s.charAt(l);
                l++;
                count[chL]--;
                maxF = Math.max(maxF, count[chL]);
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }
}
