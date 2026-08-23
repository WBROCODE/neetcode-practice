class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // fixed 

        int m = s1.length(), n = s2.length();
        if(m > n) return false;
        int[] map1 = new int[128];
        
        for(int i = 0; i < m; i++){
            map1[s1.charAt(i)]++;
        }

        int[] map2 = new int[128];
        for(int i = 0; i < m; i++){
            map2[s2.charAt(i)]++;
        }

        if(Arrays.equals(map1, map2)) return true;

        for(int i = m; i < n; i++){
            char l = s2.charAt(i - m);
            char r = s2.charAt(i);
            map2[l]--;
            map2[r]++;
            if(Arrays.equals(map1, map2)) return true;
        }        
        return false;
    }
}
