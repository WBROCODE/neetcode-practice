class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = 0, maxSum = nums[0];

        for(int num : nums){
            curSum = Math.max(curSum, 0);
            curSum += num;
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }
}
