class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int l = 0, r = 0;
        int[]counts  = new int[128];

        int ans = 0;
        while(r < n){
            counts[s.charAt(r)]++;
            while(counts[s.charAt(r)] > 1){
                counts[s.charAt(l)]--;
                l++;
                
            }
            ans = Math.max(r - l + 1, ans);
            r++;
        } 

        return ans;
    }
}
