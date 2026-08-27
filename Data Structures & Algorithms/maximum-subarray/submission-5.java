class Solution {
    public int maxSubArray(int[] nums) {
        int curS = 0;
        int ans = Integer.MIN_VALUE;

        for(int n : nums){
            if(curS < 0) curS = 0;
            curS += n;
            ans = Math.max(ans, curS);
        }

        return ans;
    }
}
