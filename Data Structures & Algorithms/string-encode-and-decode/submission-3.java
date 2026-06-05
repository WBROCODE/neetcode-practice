class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int s = 0;
        int n = str.length();
        int i = 0;
        /**
         i
        5#Hello5#World
        
        */
        while(i < n){    
            while(Character.isDigit(str.charAt(i))){
                i++;
            }
            String len = str.substring(s, i);
            int length = Integer.parseInt(len);
            s = i + 1;
            String temp = str.substring(s, s + length);
            ans.add(temp);
            i = s + length;
            s = i;
        }
        return ans;
    }
}
