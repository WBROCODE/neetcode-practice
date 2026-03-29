class Solution {
    public boolean isAnagram(String s, String t) {
        int[] mapA = new int[26];
        int[] mapB = new int[26];

        for(char ch : s.toCharArray()) mapA[ch -'a']++;
        for(char ch : t.toCharArray()) mapB[ch -'a']++;   

        for(int i = 0; i < 26;i++){
            if(mapA[i] != mapB[i]) return false;
        }    

        return true;
    }
}
