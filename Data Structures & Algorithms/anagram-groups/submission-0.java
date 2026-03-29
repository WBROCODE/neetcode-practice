class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /**
        
            K         V
        Map act       List<>{} 
        
        
        
        
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

        for(List<String> list : map.values()) ans.add(list);

        return ans;

    }
}
