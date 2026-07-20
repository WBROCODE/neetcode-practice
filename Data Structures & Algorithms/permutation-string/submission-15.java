class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // varied 
        if(s1.length() > s2.length()) return false;
        int required = 0;
        int[] mapOne = new int[128];

        for(char ch : s1.toCharArray()){
            mapOne[ch]++;
        }

        for(int i : mapOne){
            if(i != 0) required++;
        }

        int valid = 0;
        int m = s1.length();
        int l = 0, r = 0, n = s2.length();
        int[]count = new int[128];

        while(r < n){
            char chR = s2.charAt(r);
            count[chR]++;
            if(count[chR] == mapOne[chR]) valid++;
            while(r - l + 1 > m){
                char chL = s2.charAt(l);
                if(count[chL] == mapOne[chL]) valid--;
                l++;
                count[chL]--;
            }
            if(r - l + 1 == m && valid == required) return true;
            r++;
        }

        return false;
    }
}
