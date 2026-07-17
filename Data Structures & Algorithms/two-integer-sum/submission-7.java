class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            int remain = target - nums[i];

            if(map.containsKey(remain)){
                return new int[]{map.get(remain), i};
            }

            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
