class Solution {

    public String encode(List<String> strs) {
        if(strs == null || strs.size() == 0) return "";
        StringBuilder sb = new StringBuilder();

        for(String str : strs){
            sb.append(str.length()).append("#").append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str == null || str.length() == 0) return new ArrayList<>();
        List<String> ans = new ArrayList<>();

        int s = 0;
        int n = str.length();
        while(s < n){
            int e = s;
            while(str.charAt(e) != '#'){
                e++;
            }
            int len = Integer.parseInt(str.substring(s, e));
            String word = str.substring(e + 1, e + 1 + len);
            ans.add(word);
            s = e + 1 + len;
        }

        return ans;
    }
}
