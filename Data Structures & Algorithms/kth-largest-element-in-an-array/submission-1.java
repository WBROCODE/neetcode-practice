class Solution {
    int[]temp;
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        temp = new int[n];
        divide(0, n - 1, nums);   
        return nums[n - k];
    }

    public void divide(int l, int r, int[] nums){
        if(l < r){
            int m = l + (r - l) / 2;
            divide(l, m, nums);
            divide(m + 1, r, nums);
            merge(l, r, m, nums);
        }
    }

    public void merge(int l, int r, int m, int[]nums){
        for(int i = l; i <= r; i++){
            temp[i] = nums[i];
        }

        int i = l, j = m + 1;

        for(int p = l; p <= r; p++){
            if(i == m + 1){
                nums[p] = temp[j++];
            }else if(j == r + 1){
                nums[p] = temp[i++];
            }else if(temp[i] < temp[j]){
                nums[p] = temp[i++];
            }else{
                nums[p] = temp[j++];
            }



        }
    }
}
