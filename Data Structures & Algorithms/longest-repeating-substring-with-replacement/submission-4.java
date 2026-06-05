class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        int l = 0, r = 0, n = s.length();
        int[]map = new int [128];
        int freqM = 0;
        while(r < n){
            char chR = s.charAt(r);
            map[chR]++;
            freqM = Math.max(freqM, map[chR]);
            while(r - l + 1 - freqM > k){
                map[s.charAt(l)]--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }
}
