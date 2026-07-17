class Solution {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums);

        int i = 1;
        int n = nums.length;

        while(i < n){
            if(nums[i] == nums[i - 1]) return true;
            i++;
        }

        return false;

    }
}