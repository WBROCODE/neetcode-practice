class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);

        int len = 1;
        int ans = 1;
        int n = nums.length;
        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i - 1]) continue;
            if(nums[i] - nums[i - 1] == 1){
                len++;
            }else len = 1;
            ans = Math.max(len, ans);
        }

        return ans;
    }
}
