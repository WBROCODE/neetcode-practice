class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int dp_i = nums[0];
        int res = dp_i;
        for (int i = 1; i < n; i++) {
            dp_i = Math.max(nums[i], nums[i] + dp_i);
            res = Math.max(res, dp_i);
        }
        return res;
    }
}
