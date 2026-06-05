class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;


        /**
        
        1234
        l
           r 
        */


        int l = 0, r = n - 1;
        while(l < r){
            if(nums[l] + nums[r] == target){
                return new int[]{l + 1, r + 1};
            }else if(nums[l] + nums[r] < target){
                l++;
            }else{
                r--;
            }
        }

        return new int[]{};
    }
}
