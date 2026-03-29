class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        /**
        
        1 2 4 6
        */
        List<Integer> set = new ArrayList<>();
        for(int num : nums) set.add(num);
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = 0 ;  i < n ; i++){
            
            set.set(i, 1);
            int product = 1;
            for(int num : set) product *= num;  
            ans[i] = product;
            set.set(i, nums[i]);
        }

        return ans;

    }
}  
