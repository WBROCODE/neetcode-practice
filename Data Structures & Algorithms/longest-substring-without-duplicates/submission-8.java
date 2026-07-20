class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] map = new int[128];
        int l = 0, r = 0;
        int ans = 0;
        while(r < n){
            char chR = s.charAt(r);
            map[chR]++;
            while(map[chR] > 1){
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
