class Solution {
    public int maxArea(int[] heights) {
        int r = heights.length - 1, l = 0;
        int ans = 0;
        while(l < r){
            int area = Math.min(heights[r], heights[l]) * (r - l);

            if(heights[r] < heights[l]){
                r--;
            }else{
                l++;
            }
            ans = Math.max(ans, area); 
        }
        return ans;
    }
}
