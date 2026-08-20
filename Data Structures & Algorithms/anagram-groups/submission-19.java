class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        int n = strs.length;
        /**
            n: len of strs
            m: max len of str
            TC:  n * m
            SC: n * m
        */
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] key = str.toCharArray();
            int[] counts = new int[128];
            for(char ch : key){
                counts[ch]++;
            }
            String newKey = "";
            for(int i = 0; i < 128; i++){
                newKey += (counts[i] + ',');
            }
            map.computeIfAbsent(new String(newKey), k->new ArrayList<>()).add(str);
        }


        return new ArrayList<>(map.values());
    }
}
