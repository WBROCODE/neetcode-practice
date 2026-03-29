class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /**
        
        "act","pots","tops","cat","stop","hat"
        
        
        
        */
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        for(List<String> set : map.values()){
            ans.add(set);
        }
        return ans;

    }
}
