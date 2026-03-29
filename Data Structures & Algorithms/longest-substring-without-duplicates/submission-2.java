class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int l = 0, r = 0;

        int ans = 0;
        int[]map = new int[128];
        while(r < n){
            map[s.charAt(r)]++;
            while(map[s.charAt(r)] >= 2){
                map[s.charAt(l)]--;
                l++;
            }
            ans = Math.max(r - l + 1, ans);
            r++;
        }

        return ans;
    }
}
