class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int n = s.length();

        for(int i = 0; i <= n - 1; i++){
            String odd = findPalindrome(s, i, i);
            String even = findPalindrome(s, i, i + 1);
            if(even.length() > ans.length()) ans = even;
            if(odd.length() > ans.length()) ans = odd;
        }

        return ans;
    }

    public String findPalindrome(String s, int l, int r){
        int n = s.length();
        while(l >= 0 && r <= n - 1 && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}
