class Solution {
    public int characterReplacement(String s, int k) {
        /**
        AAABABB
           k   
        */


        int n = s.length();

        int l = 0, r = 0;
        int maxF = 0;
        int ans = 0;
        int[] map = new int[128];
        while(r < n){
            map[s.charAt(r)]++;
            maxF = Math.max(maxF, map[s.charAt(r)]);
            while(r - l + 1 - maxF > k){
               map[s.charAt(l)]--;
               l++; 
            }
            ans = Math.max(r - l + 1, ans);
            r++;
        }
        return ans;

    }
}
