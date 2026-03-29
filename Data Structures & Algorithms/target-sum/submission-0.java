class Solution {
    Map<String, Integer> memo;
    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        return dp(nums, target, 0);
    }

    public int dp(int[]nums, int remain, int start){     
        // base case
        if(start == nums.length){
            if(remain == 0) return 1;
            return 0;
        } 
        String key = start + "#" + remain;
        if(memo.containsKey(key)) return memo.get(key);

        int val = dp(nums, remain - nums[start], start + 1) +
                    dp(nums, remain + nums[start], start + 1);

        memo.put(key, val);
        return val;
    }


}
