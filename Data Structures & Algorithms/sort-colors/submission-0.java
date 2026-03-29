class Solution {
    public void sortColors(int[] nums) {
        int[] bucket = new int[3];

        for(int num : nums) bucket[num]++;
        int k = 0;
        for(int i = 0; i < bucket.length; i++){
            for(int j = 0; j < bucket[i]; j++){
                nums[k++] = i;
            }
        }
     
    }
}