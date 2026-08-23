class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // varied 
        // valid == required && r - l + 1 == m

        int m = s1.length(), n = s2.length();
        if(m > n) return false;
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < m; i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int required = map.size();
        int l = 0, r = 0; 
        int valid = 0;
        
        Map<Character, Integer> count = new HashMap<>();
        while(r < n){
            char chR = s2.charAt(r);
            count.put(chR, count.getOrDefault(chR, 0) + 1);
            if(count.get(chR) == map.get(chR)) valid++;
            while(r - l + 1 > m){
                char chL = s2.charAt(l);
                if(count.get(chL) == map.get(chL)) valid--;
                l++;
                count.put(chL, count.get(chL) - 1);               
            }
            if(r - l + 1 == m && valid == required) return true;
            r++;
        }

        return false;
    }
}
