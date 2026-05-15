class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**   
        zxyzxyz
           r
        l

        zz
         r
        */
        int r = 0, l = 0, n = s.length();
        int[]map = new int[128];
        int ans = 0;
        while(r < n){
            char chR = s.charAt(r);
            map[chR]++;
            while(map[chR] > 1){
                char chL = s.charAt(l);
                l++;
                map[chL]--;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
