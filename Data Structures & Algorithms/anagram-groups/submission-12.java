class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /**
        M: length of strs, N: longest of str
        K: unique of element
        SC: M + M * N
        TC: N * M 
         
        */

        int m = strs.length;
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < m; i++){
            String str = strs[i];
            char[] chs = str.toCharArray();
            String key = null;
            int[] count = new int[26];
            for(char ch : chs){
                count[ch - 'a']++;
            }

            for(int j : count){
                key += ',' + j;
            }

            map.computeIfAbsent(key, k-> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
