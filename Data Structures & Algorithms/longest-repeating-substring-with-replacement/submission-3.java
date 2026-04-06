class Solution {
    public int characterReplacement(String s, int k) {
        /**
        

        count: 0 

        XYZE
           r
        l

        012345
        AAAABBB
             r
        l
        */

        int l = 0, r = 0, n = s.length();

        int ans = 0;
        int[]map = new int[128];
        int curW = 0;
        int curF = 0;

        while(r < n){
            char chR = s.charAt(r);
            map[chR]++;
            curF = Math.max(curF, map[chR]);
            curW = r - l + 1;
            while(curW - curF > k){
                char chL = s.charAt(l);
                map[chL]--;
                l++;
                curW = r - l + 1;
            }
            ans = Math.max(ans, curW);
            r++;
        }
        return ans;
    }
}
