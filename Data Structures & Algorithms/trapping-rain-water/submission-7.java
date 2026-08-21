class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;

        int lMax = height[0];
        int rMax = height[n - 1];
        int l = 0, r = n - 1;

        while(l < r){
            if(lMax < rMax){
                ans += (lMax - height[l]);
                l++;
                lMax = Math.max(lMax, height[l]);
            }else{
                ans += (rMax - height[r]);
                r--;
                rMax = Math.max(rMax, height[r]);
            }
            
        }

        return ans;
    }
}
