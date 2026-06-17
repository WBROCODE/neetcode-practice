class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[]map = new int[128];
        int l = 0, r = 0, n = s.length();
        int ans = 0;
        while(r < n){
            char chR = s.charAt(r);
            map[chR]++;
            while(map[chR] >= 2){
                char chL = s.charAt(l);
                map[chL]--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
