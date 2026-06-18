class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int num : nums){
            total += num;
        }

        int sumL = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] + sumL * 2 == total) return i;
            sumL += nums[i];
        }

        return -1;
    }
}