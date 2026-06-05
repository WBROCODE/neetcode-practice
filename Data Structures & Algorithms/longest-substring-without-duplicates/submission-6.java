class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int l = 0, r = 0, n = s.length();
        int[]map = new int [128];
        while(r < n){
            char chR = s.charAt(r);
            map[chR]++;
            while(map[chR] > 1){
                map[s.charAt(l)]--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }
}
