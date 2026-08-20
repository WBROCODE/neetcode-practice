class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        int n = strs.length;


        /**
            n: len of strs
            m: max len of str
            TC: log m * n * m
            SC: n * m
        */

        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] key = str.toCharArray();
            Arrays.sort(key);
            map.computeIfAbsent(new String(key), k->new ArrayList<>()).add(str);
        }


        return new ArrayList<>(map.values());
    }
}
