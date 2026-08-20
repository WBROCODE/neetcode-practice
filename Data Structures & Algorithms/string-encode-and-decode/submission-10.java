class Solution {

    public String encode(List<String> strs) {
        /**
            5hello*
        

        */
        if(strs.isEmpty() || strs.size() == 0) return null;

        StringBuilder sb = new StringBuilder();

        for(String s : strs){
            sb.append(s.length());
            sb.append("*");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str == null || str.length() == 0) return new ArrayList<>();
        List<String> ans = new ArrayList<>();

        for(int i = 0; i < str.length();){
            int digit = 0;
            int start = i;
            int len = 0;
            while(Character.isDigit(str.charAt(start))){
                digit = digit * 10 + (str.charAt(start) - '0');
                start++;
            }
            /**
               s  
            1* 
            */
            start++;
            ans.add(str.substring(start, start + digit));
            i = start + digit;
        }

        return ans;
    }
}
