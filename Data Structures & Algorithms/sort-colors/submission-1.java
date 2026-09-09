class Solution {
    public void sortColors(int[] nums) {

        int n = nums.length;
        int[] bucket = new int[3];
        for(int num : nums) bucket[num]++;
        /**
            1   2   1
            0   1   2
        
        */
        int k = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < bucket[i]; j++){
                nums[k++] = i;
            }
        }

    }
}