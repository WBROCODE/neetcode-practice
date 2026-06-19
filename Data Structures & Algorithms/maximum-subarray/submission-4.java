class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int curS = 0;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(curS < 0){
               curS = 0;
            }
            curS += nums[i];
            ans = Math.max(ans, curS); 
        }

        return ans;
    }
}
