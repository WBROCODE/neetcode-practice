class Solution {
    public int countSubstrings(String s) {
       if(s == null || s.length() == 0) return 0;
        int n = s.length();
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans += findPalindrome(i, i, s);
            ans += findPalindrome(i, i + 1, s);
        }
        return ans;
    }

    public int findPalindrome(int s, int e, String str){
        int ans = 0;
        while(s >= 0 && e <= str.length() - 1 && str.charAt(e) == str.charAt(s)){
            s--;
            e++;    
            ans++;
        }        
        return ans;
    }
}
