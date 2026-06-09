class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
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
            if(Arrays.equals(mapTwo, mapOne)) return true; 
        }

        return false;
    }
}
