class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            int size = str.length();
            sb.append(size).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();

        int i = 0;

        while(i < str.length()){

            int j = i;

            while(str.charAt(j) != '#') j++;
            int len = Integer.parseInt(str.substring(i,j));
            i = j + 1;
            j = len + i;
            ans.add(str.substring(i,j));
            i = j;
        }
        return ans;
    }
}
