class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(nums == null || n == 0) return 0;
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) set.add(num);
        int ans = 1;
        for(int num : set){
            int len = 1;
            if(!set.contains(num - 1)){
                while(set.contains(num + len)){
                    len++;
                }
                ans = Math.max(len, ans);
            }
        }
        return ans;
    }
}
