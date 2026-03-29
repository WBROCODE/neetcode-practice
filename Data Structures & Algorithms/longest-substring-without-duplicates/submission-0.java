class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0,  right = 0, n = s.length();

        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;

        while(right < n){
            char charR = s.charAt(right);
            

            map.put(charR, map.getOrDefault(charR, 0) + 1);

            while(map.get(charR) >= 2){
                char charL = s.charAt(left);
                left++;
                map.put(charL, map.get(charL) - 1);
            }
            ans = Math.max(right - left + 1, ans);
            right++;
        }
        return ans;

    }
}
