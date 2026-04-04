class Solution {

    public String encode(List<String> strs) {
        /**
        "Hello","World"
        "5Hello#5World#"
        “##”
        */
        if(strs == null || strs.size() == 0) return null;
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str == null || str.length() == 0) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int n = str.length();

        int s = 0;
        StringBuilder sb = new StringBuilder();
        while(s < n){
            char ch = str.charAt(s);
            int len = 0;
            while(Character.isDigit(ch)){
                len = len * 10 + (ch - '0');
                s++;    
                ch = str.charAt(s);
            }
            if(ch == '#') s++;
            String cur = str.substring(s, s + len);
            ans.add(cur);
            s += len;  
        }

        
        return ans;
    }
}
