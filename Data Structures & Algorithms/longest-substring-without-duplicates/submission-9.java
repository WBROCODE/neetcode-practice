class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**
        
            0 1 2 3 4 5 6
            z x y z x y z
                  r
            l      

            pwwkew        
            r
            l 
        */

        int n = s.length();
        int l = 0 , r = 0, ans = 0;

        int[]count = new int[128];
        while(r < n){
            char chR = s.charAt(r);
            count[chR]++;
            while(count[chR] > 1){
                char chL = s.charAt(l);
                l++;
                count[chL]--;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }
}
