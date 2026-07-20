class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if(n > m) return "";
        int[] map = new int[128];
        for(char ch : t.toCharArray()){
            map[ch]++;
        }
        int required = 0;
        for(int i : map){
            if(i == 0) continue;
            else required++;
        }

        int l = 0, r = 0;
        int valid = 0;
        int start = 0;
        int[]count = new int[128];
        int len = Integer.MAX_VALUE;
        while(r < m){
            char chR = s.charAt(r);
            count[chR]++;
            if(count[chR] == map[chR]) valid++;
            while(valid == required){
                if(len > r - l + 1){
                    len = r - l + 1;
                    start = l;
                }
                char chL = s.charAt(l);
                if(count[chL] == map[chL]) valid--;
                count[chL]--;                
                l++;
            }
            r++;
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
