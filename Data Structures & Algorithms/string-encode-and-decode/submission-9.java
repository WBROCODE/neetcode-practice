class Solution {

    public String encode(List<String> strs) {
        // strs

        /**
        
        hello,world
        ,world
        
        
        */
        if(strs == null || strs.size() == 0) return "";

        StringBuilder sb = new StringBuilder();

        for(String str : strs){
            sb.append(str.length());
            sb.append(',');
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str == null) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int i = 0, n = str.length();

        while(i < n){
            int curL = 0;
            while(Character.isDigit(str.charAt(i))){
                curL = curL * 10 + (int)str.charAt(i) - '0';
                i++;
            }
            i++;
            String cur = str.substring(i, i + curL);
            ans.add(cur);
            i += curL;
        }
        return ans;
    }
}
