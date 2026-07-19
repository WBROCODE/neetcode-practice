class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int lM = heights[l], rM = heights[r];
        int ans = 0;
        while(l < r){
            int area = Math.min(lM, rM) * (r - l);
            if(lM < rM){
                l++;
                lM = Math.max(lM, heights[l]);
            }else{
                r--;
                rM = Math.max(rM, heights[r]);
            }
            ans = Math.max(area, ans);
        }

        return ans;
    }
}
