class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
    
        for(int i = 0; i < n; i++){
            String odd = isPalindrom(s, i, i);
            String even = isPalindrom(s, i, i + 1);
            if(odd.length() > ans.length()) ans = odd;
            if(even.length() > ans.length()) ans = even;
        }

        return ans;
    }

    public String isPalindrom(String s, int l, int r){
        int n = s.length();
        while(r < n && l >= 0 && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }

        return s.substring(l + 1, r) ;
    }
}
