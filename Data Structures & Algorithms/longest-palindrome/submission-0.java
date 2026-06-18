class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int ans = 0;
        for(char ch : s.toCharArray()){
            if(set.contains(ch)){
                ans+=2;
                set.remove(ch);
            }
            else{
                set.add(ch);
            }
        }
        if(!set.isEmpty()) ans++;
        return ans;
    }
}