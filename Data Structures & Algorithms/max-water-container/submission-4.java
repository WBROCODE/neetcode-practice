class Solution {
    public int maxArea(int[] heights) {
        // TC: N SC: 1
        int ans = 0;
        int l = 0, r = heights.length - 1;
        while(l < r){
            int area = (r - l) * Math.min(heights[l], heights[r]);

            if(heights[l] < heights[r]){
                l++;
            }else{
                r--;
            }
            ans = Math.max(ans, area);
        }

        return ans;
    }
}
