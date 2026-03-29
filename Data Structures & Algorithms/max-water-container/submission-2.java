class Solution {
    public int maxArea(int[] heights) {

        int l = 0, r = heights.length - 1;

        int lM = heights[0];
        int rM = heights[r];
        int ans = Math.min(lM, rM) * (r - l);
        while(l < r){
            if(lM < rM){
                l++;
                lM = Math.max(lM, heights[l]);
                ans = Math.max(ans, Math.min(lM, rM) * (r -l));
            }else{
                r--;
                rM = Math.max(rM, heights[r]);
                ans = Math.max(ans, Math.min(lM, rM) * (r -l));            
            }
        }

        return ans;
    }
}
