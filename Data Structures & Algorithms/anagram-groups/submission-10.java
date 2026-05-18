class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n =strs.length; 
        Map<String, List<String>> keys = new HashMap<>();
        for(int i = 0; i < n; i++){
            char[] chs = strs[i].toCharArray();
            int[] map = new int[26];
            for(char ch : chs){
                map[ch - 'a']++;
            }
            String key = null;
            for(int j : map){
                key = key + ',' + j;
            }
            keys.computeIfAbsent(key, k->new ArrayList<>()).add(strs[i]);

        }

        return new ArrayList<>(keys.values());
    }
}
