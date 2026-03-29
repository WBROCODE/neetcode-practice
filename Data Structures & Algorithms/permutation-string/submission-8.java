class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /**
            0 1 2 3 4 5 6                   aabb        a 
            l e c a b e e                   l 1, e 3, a 1, b 1, c1  
            0 0 0 0                         

            a b c
            1 1 1 
        
        */
        if(s2.length() < s1.length()) return false;
        int[]mapOne = new int[128];
        int[]mapTwo = new int[128];

        for(char ch : s1.toCharArray()){
            mapOne[ch]++;
        }
        for(int i = 0; i < s1.length(); i++){
            mapTwo[s2.charAt(i)]++;
        }
        
        if(Arrays.equals(mapOne, mapTwo)) return true;

        for(int i = s1.length(); i < s2.length(); i++){
            mapTwo[s2.charAt(i)]++;
            mapTwo[s2.charAt(i - s1.length())]--;
            if(Arrays.equals(mapOne, mapTwo)) return true;
        }    


        return false;
    }
}