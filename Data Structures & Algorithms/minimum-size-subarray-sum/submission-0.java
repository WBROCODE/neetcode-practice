class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int curSum = 0;

        while(right < nums.length){
            curSum+= nums[right];
            while(curSum >= target){
                ans = Math.min(ans, right - left + 1);
                curSum-= nums[left++];
            }
            right++;
        }

        return ans == Integer.MAX_VALUE? 0 : ans;
    }
}