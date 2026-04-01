class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // SC: M * N  TC: N * M
        // M : longest len of str, n: len of strs
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            int[]counts = new int[26];
            for(char ch : str.toCharArray()){
                counts[ch -'a']++;
            }
            String key = "";
            for(int c : counts){
                key += c + ",";
            }
            
            map.computeIfAbsent(key, k->new ArrayList<>()).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}
