class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int ans = 1;
        for(int i = 1; i < n; i++){
            int cur = nums[i];
            int prev = nums[i - 1];
            if(prev != cur){
                nums[ans++] = nums[i];
            }
        }
        return ans;
    }
}