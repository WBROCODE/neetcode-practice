class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        int n = s.length();
        int left = 0, right = 0;
        int maxW = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        while(right <= n - 1){
            char chR = s.charAt(right);
            window.put(chR, window.getOrDefault(chR, 0) + 1);
            maxW = Math.max(maxW, window.get(chR));
            while(right - left + 1 - maxW > k){
                char chL = s.charAt(left);
                window.put(chL, window.get(chL) - 1);
                left++;
            }

            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans == Integer.MIN_VALUE? 0 : ans;
    }
}
