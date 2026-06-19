class Solution {
    public int[] sortArray(int[] nums) {
        // Quick Sort
        int n = nums.length;
        quickSort(0, n - 1, nums);
        return nums;
    }

    public void quickSort(int left, int right, int[]nums){
        if(left >= right) return;
        int pivot = nums[left + (right - left) / 2];
        int l = left;
        int r = right;

        while(l <= r){
            while(nums[l] < pivot){
                l++;
            }

            while(nums[r] > pivot){
                r--;
            }

            if(l <= r){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
        }

        quickSort(left, r, nums);
        quickSort(l, right, nums);
    }
}