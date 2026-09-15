class Solution {

    public String encode(List<String> strs) {
        if(strs == null || strs.size() == 0) return "";
        
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length());
            sb.append(",");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str == null || str.length() == 0) return new ArrayList<>();
        List<String> ans = new ArrayList<>();

        int i = 0;
        while(i < str.length()){
            int num = 0;
            while(Character.isDigit(str.charAt(i))){
                num = num * 10 + str.charAt(i) - '0';
                i++;
            }
            i++;
            ans.add(str.substring(i, i + num));
            i = i + num;
        }

        return ans;
    }
}
