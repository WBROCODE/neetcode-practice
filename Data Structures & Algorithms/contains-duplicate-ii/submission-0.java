class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> window = new HashSet<>();
        int left = 0;

        for(int right = 0; right < nums.length; right++){
            if(window.contains(nums[right])) return true;
            if(window.size() >= k){
                window.remove(nums[left]);
                left++;
            }
            window.add(nums[right]);
        }
        return false;
    }
}