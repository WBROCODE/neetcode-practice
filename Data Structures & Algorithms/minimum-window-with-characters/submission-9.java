class Solution {
    public String minWindow(String s, String t) {
        /**
        
        
        OUZODYXAZV
               r
        l
        
        valid

        map 
        */

        Map<Character, Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int required = map.size();
        int l = 0, r = 0, n = s.length();
        int valid = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        Map<Character, Integer> mapC = new HashMap<>();
        while(r < n){
            char chR = s.charAt(r);
            mapC.put(chR, mapC.getOrDefault(chR, 0) + 1);
            r++;
            if(map.containsKey(chR) && mapC.get(chR) == map.get(chR)){
                valid++;
            }
            while(valid == required){
                if(r - l < minLen){
                    minLen = r - l;
                    start = l;
                }
                char chL = s.charAt(l);
                l++;
                if(map.containsKey(chL) && mapC.get(chL) == map.get(chL)){
                    valid--;
                }
                mapC.put(chL, mapC.get(chL) - 1);
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
