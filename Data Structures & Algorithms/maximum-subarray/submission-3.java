class Solution {
    public int maxSubArray(int[] nums) {
        /**
            0 1  2  3 4 5  6 7
            2,-3,4,-2,2,1,-1,4   

        
        */


        int n = nums.length;
        int[] prefix = new int[n + 1];
        prefix[0] = 0;
        for(int i = 1; i <= n; i++){
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        int min = 0;
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            ans = Math.max(ans, prefix[i] - min);
            min = Math.min(min, prefix[i]);
        }    

        return ans;
    }
}
