class Solution {
    public String minWindow(String s, String t) {
        /**
            
            0123456789
            OUZODYXAZV

                 s


        */
     
        int[]mapOne = new int[128];
        int[]mapTwo = new int[128];
        int required = 0;
        for(char ch : t.toCharArray()){
            mapOne[ch]++;
        }
        for(int i = 0; i < 128; i++){
            if(mapOne[i] != 0) required++;
        }
        int valid = 0;
        int l = 0, r = 0, n = s.length();
        int len = Integer.MAX_VALUE;
        int start = 0;
        while(r < n){
            char chR = s.charAt(r);
            mapTwo[chR]++;
            if(mapOne[chR] > 0 && mapTwo[chR] == mapOne[chR]) valid++;
            while(valid == required){
                if(r - l + 1 < len){
                    len = r - l + 1;
                    start = l; 
                }
                char chL = s.charAt(l);
                mapTwo[chL]--;

                if(mapOne[chL] > 0 && mapTwo[chL] < mapOne[chL]) valid--;
                l++;
            }
            r++;
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
