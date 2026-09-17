class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length(), l = 0, r = 0;
        int[]map = new int[128];
        int cM = 0;
        int ans = 0;
        while(r < n){
            map[s.charAt(r)]++;
            cM = Math.max(cM, map[s.charAt(r)]);
            while(r  - l  + 1 - cM > k){
                map[s.charAt(l)]--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }
}
