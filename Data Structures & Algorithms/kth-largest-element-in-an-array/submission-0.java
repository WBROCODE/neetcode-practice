class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int target = nums.length - k;

        while (left <= right) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == target) {
                return nums[pivotIndex];
            } else if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
        return -1;
    }

    public int partition(int[] nums, int left, int right){
        int pivot = nums[right];
        int store = left;
        for(int i = left; i < right; i++){
            if(nums[i] < pivot){
                swap(nums, i, store);
                store++;
            }
        }
        swap(nums, store, right);
        return store;
    }

    public void swap(int[] pairs, int i, int j){
        int temp  = pairs[i];
        pairs[i] =  pairs[j];
        pairs[j] = temp;
    }

}
