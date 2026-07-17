class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /**
        M: length of strs, N: longest of str
        K: unique of element
        TC: K + M 
        SC: N * logN * M 
        
        */

        int m = strs.length;
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < m; i++){
            String str = strs[i];
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);
            map.computeIfAbsent(key, k-> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
