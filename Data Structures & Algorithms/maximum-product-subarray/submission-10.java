class Solution {
    public int maxProduct(int[] nums) {
        /**
        
        
        

                2 4 -3 5 
            max
            min
        
        
        */

        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        max[0] = nums[0];
        min[0] = nums[0];

        for(int i = 1; i < n; i++){
            max[i] = Math.max(min[i - 1] * nums[i], Math.max(max[i - 1] * nums[i], nums[i]));
            min[i] = Math.min(min[i - 1] * nums[i], Math.min(max[i - 1] * nums[i], nums[i]));
        }

        int ans = Integer.MIN_VALUE;

        for(int m : max){
            ans = Math.max(m, ans);
        }
        return ans;
    }   
}
