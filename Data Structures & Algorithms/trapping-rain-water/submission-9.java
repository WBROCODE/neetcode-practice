class Solution {
    public int trap(int[] height) {
        // left Max
        int n = height.length;
        int lM = height[0], rM = height[n - 1];
        int l = 0, r = n - 1;
        int ans = 0;
        while(l < r){

            if(lM > rM){
                ans += (rM - height[r]);
                r--;
                rM = Math.max(rM, height[r]);
            }else{
                ans += (lM - height[l]);
                l++;
                lM = Math.max(lM, height[l]);                
            }


        }


       
        return ans;
    }
}
