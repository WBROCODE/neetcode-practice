class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);
            map.computeIfAbsent(key, k->new ArrayList<>()).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}
