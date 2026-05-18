class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n =strs.length; 
        Map<String, List<String>> keys = new HashMap<>();
        for(int i = 0; i < n; i++){
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);
            if(keys.containsKey(key)){
                List<String> temp = keys.get(key);
                temp.add(strs[i]);
                keys.put(key, temp);
            }else{
                keys.put(key, new ArrayList<>());
                List<String> temp = keys.get(key);
                temp.add(strs[i]);
                keys.put(key, temp);
            }
        }

        return new ArrayList<>(keys.values());
    }
}
