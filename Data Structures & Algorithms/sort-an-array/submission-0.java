class Solution {
    int[]temp;
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        temp = new int[n];
        divide(0, n - 1, nums);
        return nums;
    }

    public void divide(int l, int r, int[]nums){
        if(l < r){
            int m = l + (r - l) / 2;
            divide(l, m, nums);
            divide(m + 1, r, nums);
            merge(l, m, r, nums);
        }
    }

    public void merge(int l ,int m, int r, int[]nums){
        for(int c = l; c <= r; c++){
            temp[c] = nums[c];
        }

        int i = l, j = m + 1;

        for(int p = l; p <= r; p++){
            if(i == m + 1){
                nums[p] = temp[j];
                j++;
            }else if(j == r + 1){
                nums[p] = temp[i];
                i++;               
            }else if(temp[i] > temp[j]){
                nums[p] = temp[j];
                j++;
            }else{
                nums[p] = temp[i];
                i++;                
            }
        }
    }
}