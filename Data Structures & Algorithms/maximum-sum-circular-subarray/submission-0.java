class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int curMax = 0, maxSum = nums[0];
        int curMin = 0, minSum = nums[0];
        int total = 0;
        for(int num : nums){
            total += num;
            curMax = Math.max(num, curMax + num);
            curMin = Math.min(num, curMin + num);
            maxSum = Math.max(curMax, maxSum);
            minSum = Math.min(curMin, minSum);
        }
        return maxSum < 0 ? maxSum : Math.max(total - minSum, maxSum);
    }
}