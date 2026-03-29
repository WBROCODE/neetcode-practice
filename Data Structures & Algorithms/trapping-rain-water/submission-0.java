class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int l = 0, r = height.length - 1;
        int lMax= height[l], rMax = height[r];
        while(l < r){
            if(lMax < rMax){
                l++;
                lMax = Math.max(lMax, height[l]);
                ans += lMax - height[l];
            }else{
                r--;
                rMax = Math.max(rMax, height[r]);
                ans += rMax - height[r];
            }
        }
        return ans;

    }
}
