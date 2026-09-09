class Solution {
    public int maxArea(int[] nums) {
        int ans = 0;

        int n = nums.length;
        int l = 0, r = n - 1;


        while(l < r){
            ans = Math.max(ans, Math.min(nums[r], nums[l]) * (r - l));
            if(nums[l] < nums[r]){
                l++;
            }else{
                r--;
            }
          

        }
        return ans;
    }
}
