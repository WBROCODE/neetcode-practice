class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // SW
        if(k <= 1) return 0;
        int product = 1;
        int l = 0, r = 0, n = nums.length;
        int ans = 0;
        while(r < n){
            int numR = nums[r];
            product *= numR;
            while(product >= k){
                int numL = nums[l];
                product /= numL;
                l++;  
            }
            ans += (r - l + 1); 
            r++;
        }

        return ans;

    }
}