class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int ans = 0;

        while(left < right){

            int area = Math.min(heights[left], heights[right]) * (right - left);
            
            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
            
            ans = Math.max(ans, area);

        }
        return ans;
    }
}
