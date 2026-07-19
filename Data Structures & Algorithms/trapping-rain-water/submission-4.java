class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = height.length - 1;
        int lM = height[0];
        int rM = height[n - 1];
        int ans = 0;
        while(l < r){ 
            if(lM < rM){
                ans += (lM - height[l]);
                l++;
                lM = Math.max(height[l], lM);
            }else{
                ans += (rM - height[r]);
                r--;
                rM = Math.max(height[r], rM);
            }
        }
   
        return ans;
    }
}
