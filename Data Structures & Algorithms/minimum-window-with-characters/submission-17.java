class Solution {
    public String minWindow(String s1, String s2) {
        /**
        
            OUZODYXAZV  
                  r
              l
            valid == required

            shrink(min window size)


            XYZ required
        */
        int m = s1.length(), n = s2.length();
        if(n > m) return "";
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) + 1);
        }

        int required = map.size();
        int l = 0, r = 0; 
        int valid = 0;
        int start = 0;
        int len = m + 1;
        Map<Character, Integer> count = new HashMap<>();
        while(r < m){
            char chR = s1.charAt(r);
            count.put(chR, count.getOrDefault(chR, 0) + 1);
            if(count.get(chR).equals(map.get(chR))) valid++;
            while(valid == required){
             
                char chL = s1.charAt(l);
                if(count.get(chL).equals(map.get(chL))){
                    valid--;
                }
                if(len > r - l + 1){
                    start = l;
                    len = Math.min(len, r - l + 1);
                }
                l++;
                count.put(chL, count.get(chL) - 1);               
            }
            r++;
        }

        return len == m + 1? "" : s1.substring(start, start + len);


    }
}
