class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();


        for(String str : strs){
            int[] counts = new int[128]; // 26
            for(char ch : str.toCharArray()){
                counts[ch]++;
            }
            String key = "";
            for(int i = 0; i < 128; i++){
                key += counts[i];
                key += ",";
            } 
            map.computeIfAbsent(key, k-> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
