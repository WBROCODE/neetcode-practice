class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        for(int i = 0; i < n; i++){
            String odd = palindrom(s, i, i);
            String even = palindrom(s, i, i + 1);
            if(odd.length() > ans.length()) ans = odd;
            if(even.length() > ans.length()) ans = even;
        }
        return ans;
    }

    public String palindrom(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }

        return s.substring(l + 1, r);
    }
}
