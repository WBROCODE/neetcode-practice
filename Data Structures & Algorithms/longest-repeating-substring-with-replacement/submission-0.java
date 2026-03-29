class Solution {
    public int characterReplacement(String s, int k) {
        /**
                L
            AAABABB
        
        
        */

        int ans = 0, l = 0, r = 0, n = s.length();
        int[] map = new int[26];
        int maxW = 0;

        while(r < n){
            char chR = s.charAt(r);
            map[chR - 'A']++;
            maxW = Math.max(maxW, map[chR - 'A']);
            while(r - l + 1 - maxW > k){
                char chL = s.charAt(l);
                l++;
                map[chL - 'A']--;
            }
            ans = Math.max(ans, r - l + 1);
            r++;

        }

        return ans;
    }
}
