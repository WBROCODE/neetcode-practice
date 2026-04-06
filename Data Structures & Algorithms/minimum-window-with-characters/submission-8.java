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
        String ans = s + "a";
        Map<Character, Integer> mapC = new HashMap<>();
        while(r < n){
            char chR = s.charAt(r);
            mapC.put(chR, mapC.getOrDefault(chR, 0) + 1);
            r++;
            if(map.containsKey(chR) && mapC.get(chR) == map.get(chR)){
                valid++;
            }
            while(valid == required){
                char chL = s.charAt(l);
                l++;
                if(map.containsKey(chL) && mapC.get(chL) == map.get(chL)){
                    valid--;
                    start = l - 1;
                    String sub = s.substring(start, r);
                    if(sub.length() < ans.length()){
                        ans = sub;
                    }
                }
                mapC.put(chL, mapC.get(chL) - 1);
            }
        }
        return ans.equals(s + "a") ? "" : ans;
    }
}
