class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int ans = 0;
        while(l < r){
            int area = Math.min(heights[l], heights[r]) * (r - l);
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
