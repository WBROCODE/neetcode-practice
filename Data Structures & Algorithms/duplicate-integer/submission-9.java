class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            if(set.contains(num)) return true;
            set.add(num);
        }

        return false;
    }
}