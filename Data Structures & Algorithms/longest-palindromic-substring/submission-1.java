class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        int n = s.length();
        String ans = "";
        for(int i = 0; i < n; i++){
            String evenC = findPalindrome(i, i + 1, s);
            String oddC = findPalindrome(i, i, s);
            if(evenC.length() > ans.length()) ans = evenC;
            if(oddC.length() > ans.length()) ans = oddC;
        }
        return ans;
    }

    public String findPalindrome(int s, int e, String str){
        while(s >= 0 && e <= str.length() - 1 && str.charAt(e) == str.charAt(s)){
            s--;
            e++;
        }        
        return str.substring(s + 1, e);
    }
}
