class Solution {
    public boolean isAnagram(String s, String t) {
        int[] chS = new int[128];

        for(char ch : s.toCharArray()){
            chS[ch]++;
        }
        for(char ch : t.toCharArray()){
            chS[ch]--;
        }

        for(int i = 0; i < 128; i++){
            if(chS[i] != 0) return false; 
        }

        return true;
    }
}
