class Solution {
    public String minWindow(String s, String t) {

        /**
            XYZ
        valid == count.size

            0 1 2 3 4 5 6 7 8 9
                          R
            L
            O U Z O D Y X A Z V
            ans = R - L + 1 = 7     
            0 1 2 3 4 5 6 7 8 9
                        R
                L
            O U Z O D Y X A Z V
            ans = R - L + 1= 5           
            0 1 2 3 4 5 6 7 8 9
                            R
                L
            O U Z O D Y X A Z V
            ans = R - L = 4         
        */
        Map<Character, Integer> counts = new HashMap<>();
        for(char ch : t.toCharArray()) counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        int valid = 0, l = 0, r = 0, n = s.length();
        int start = 0;
        int size = counts.size(); 
        int ans = Integer.MAX_VALUE;
        Map<Character, Integer> window = new HashMap<>();

        while(r < n){
            char chR = s.charAt(r);
            window.put(chR, window.getOrDefault(chR, 0) + 1);
            if(counts.containsKey(chR) && window.get(chR).equals(counts.get(chR))) valid++;

            while(valid == size){
                if(ans > r - l + 1){
                    ans = r - l + 1;
                    start = l;
                }
                char chL = s.charAt(l);
                l++;
                window.put(chL, window.getOrDefault(chL, 0) - 1);
                if(counts.containsKey(chL) && window.get(chL) < counts.get(chL)) valid--;
            }
            r++;
        }
        return ans == Integer.MAX_VALUE ? "" : s.substring(start, start + ans);
    }
}
