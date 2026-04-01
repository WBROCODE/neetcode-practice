class Solution {
    public boolean hasDuplicate(int[] nums) {
        /**
        
        
            1, 2, 3, 1, 2, 3
            i
                      j
        
        */

        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        int i = 0;
        while(i < n){
            if(set.contains(nums[i])) return true;
            set.add(nums[i++]);
        }
        return false;
    }
}