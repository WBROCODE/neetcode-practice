class Solution {
    public int longestConsecutive(int[] nums) {
        // SC: N TC : N
        if(nums == null || nums.length == 0) return 0;
        int ans = 1;
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        for(int key : set){
            if(set.contains(key - 1)){
                int len = 1;
                while(set.contains(key - 1 + len)){
                    len++;
                }
                ans = Math.max(len, ans);
            }
        }
        return ans;
    }
}
