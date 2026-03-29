class Solution {
    public String minWindow(String s, String t) {
        /**
        
        X Y Z
        
        Freq
        
        t > x 
        
        OUZODYXAZV
                 r
              l
        */
        int[] mapOne = new int[128];
        int required = 0;
        for(char ch : t.toCharArray()){
            mapOne[ch]++;
        }
        for(int n : mapOne){
           if(n != 0) required++;
        }
        int l = 0, r =0, n = s.length();
        int start = 0;
        int valid = 0;
        int[] mapTwo = new int[128];
        int ans = Integer.MAX_VALUE;
        while(r < n){
            char chR = s.charAt(r);
            mapTwo[chR]++;
            if(mapTwo[chR] == mapOne[chR]) valid++;
            while(valid == required){
                if(r - l + 1 < ans){
                    ans = r - l + 1;
                    start = l;
                }
                char chL = s.charAt(l);
                mapTwo[chL]--;
                if(mapTwo[chL] < mapOne[chL]) valid--;
                l++;
            }
            r++;
        }

        return ans == Integer.MAX_VALUE? "" : s.substring(start, start + ans);
    }
}
