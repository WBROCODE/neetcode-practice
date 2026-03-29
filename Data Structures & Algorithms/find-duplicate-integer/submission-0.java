class Solution {
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length;

        while(left < right){
            int mid = left + (right - left) / 2;

            int lessOrEqual = 0;

            for(int num : nums){
                if(num <= mid){
                    lessOrEqual++;
                }
            }

            if(lessOrEqual <= mid){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
