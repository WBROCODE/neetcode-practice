class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int r = 0, l = 0, n = nums.length;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while(r < n){
            sum+=nums[r];
            while(sum >= target){
                ans = Math.min(r - l + 1, ans);
                sum -= nums[l++];
            }
            r++;
        }

        return ans == Integer.MAX_VALUE? 0 : ans;
    }
}