class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        int curS = 0;
        for(int num : nums){
            curS += num;
            int diff = curS - k;
            ans+= map.getOrDefault(diff, 0);
            map.put(curS, map.getOrDefault(curS, 0) + 1);
        }

        return ans;

    }
}