class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if(n > m) return "";
        int start = 0;
        int len = Integer.MAX_VALUE;
        Map<Character, Integer> mapT = new HashMap<>();
        Map<Character, Integer> mapS = new HashMap<>();
        for(char ch : t.toCharArray()) mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
        int required = mapT.size();

        int l = 0, r = 0;
        int valid = 0;
        while(r < m){
            char chR = s.charAt(r);
            mapS.put(chR, mapS.getOrDefault(chR, 0) + 1);
            if(mapS.get(chR).equals(mapT.get(chR))) valid++;
            while(valid == required){
                char chL = s.charAt(l);
                if(mapS.get(chL).equals(mapT.get(chL))){
                    valid--;
                }
                if(len > r - l + 1){
                    start = l;
                    len = Math.min(len, r - l + 1);
                }
                mapS.put(chL, mapS.get(chL) - 1);
                l++;
            }
            r++;
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
