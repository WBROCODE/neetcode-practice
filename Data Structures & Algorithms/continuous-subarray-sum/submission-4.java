class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i <= nums.length; i++){
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        for(int i = 0; i <= nums.length; i++){
            int mod = prefix[i] % k;
            if(map.containsKey(mod) && i - map.get(mod) >= 2){
                return true;
            }
            map.putIfAbsent(mod, i);
        }

        return false;
    }
}