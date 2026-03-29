class Solution {
    public int[] productExceptSelf(int[] nums) {

        /**
        
             0.             1           2              3
        pref 1              1           1 * 2       1 * 2 * 4
        suff 4 * 6 * 2      4 * 6       6          1
        
        */

        int n = nums.length;
        int[] ans = new int[n];
        
        int[]prefix = new int[n];
        int[]suffix = new int[n];
        /**
        
               0 1 2  3
           N:  1 2 3  4 
           P:  1 2  6  24
           S: 24 24 12 4

         */
        prefix[0] = nums[0];
        for(int i = 1; i <= n - 1; i++){
            prefix[i] = prefix[i - 1] * nums[i]; 
        }

        suffix[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            suffix[i] = suffix[i + 1] * nums[i]; 
        }

        ans[0] = suffix[1];
        ans[n - 1] = prefix[n - 2];

        for(int i = 1; i <= n - 2; i++){
            ans[i] = suffix[i + 1] * prefix[i - 1];
        }
        return ans;

    }
}  
