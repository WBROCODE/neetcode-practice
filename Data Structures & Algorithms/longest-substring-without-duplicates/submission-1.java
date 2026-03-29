class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = Integer.MIN_VALUE;
        int n = s.length();
        int left = 0, right = 0;
        Set<Character> window = new HashSet<>();
        while(right <= n - 1){
            char chR = s.charAt(right);
            while(window.contains(chR)){
                char chL = s.charAt(left);
                window.remove(chL);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            window.add(chR);
            right++;
        }
        return ans == Integer.MIN_VALUE? 0 : ans;
    }
}
