class Solution {
    public int characterReplacement(String s, int k) {
        /**
            XYYX
            r - l + 1 

            - curW > k


            curW = Max(r)
        */
        int n = s.length();
        int[] map = new int[128];
        int l = 0, r = 0;
        int ans = 0;
        int curW = 0;
        while(r < n){
            char chR = s.charAt(r);
            map[chR]++;
            curW = Math.max(curW, map[chR]);
            while(r - l + 1 - curW > k){
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
