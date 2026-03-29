class Solution {
    public int maxProduct(int[] nums) {
        /**
        
        min 1 1 -3  -12

        max 1 2 2   4
        


        */
        int n = nums.length;
        int[] minDp = new int[n];
        int[] maxDp = new int[n];

        maxDp[0] = nums[0];
        minDp[0] = nums[0];

        for(int i = 1; i < n; i++){
            minDp[i] = Math.min(minDp[i - 1] * nums[i], Math.min(nums[i], maxDp[i - 1] * nums[i]));
            maxDp[i] = Math.max(minDp[i - 1] * nums[i], Math.max(nums[i], maxDp[i - 1] * nums[i]));
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, maxDp[i]);
        }

        return res;
    }
}
