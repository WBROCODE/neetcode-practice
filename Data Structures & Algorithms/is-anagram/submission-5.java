class Solution {
    public boolean isAnagram(String s, String t) {
        int[]map = new int[128];
        for(char c : s.toCharArray()){
            map[c]++;
        }
        for(char c : t.toCharArray()){
             map[c]--;
        }

        for(int a : map){
            if(a != 0) return false;
        }
        return true;
    }
}
