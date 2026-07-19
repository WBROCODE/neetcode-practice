class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] lM = new int[n];
        int[] rM = new int[n];
        lM[0] = height[0];
        rM[n - 1] = height[n - 1];

        for(int i = 1; i < n; i++){
            lM[i] = Math.max(height[i], lM[i - 1]);
        }

        for(int i = n - 2; i >= 0; i--){
            rM[i] = Math.max(height[i], rM[i + 1]);
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans += Math.min(lM[i], rM[i]) - height[i];
        }

        return ans;
    }
}
