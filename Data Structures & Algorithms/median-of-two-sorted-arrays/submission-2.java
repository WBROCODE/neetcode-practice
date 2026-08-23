class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
            1 3
        
            2 4 
        
        */

        int m = nums1.length, n = nums2.length;
        if(n < m) return findMedianSortedArrays(nums2, nums1);
        int l = 0, r = m;
        int half = (m + n + 1) / 2;

        while(l <= r){
            int i = l + (r - l) / 2;
            int j = half - i;

            int l1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int l2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            // 
            int r1 = i == m ? Integer.MAX_VALUE : nums1[i];
            int r2 = j == n ? Integer.MAX_VALUE : nums2[j];
            if(l1 > r2){
                r = i - 1;
            }else if(l2 > r1){
                l = i + 1;
            }else{

                if((m + n) % 2 == 1){
                    return Math.max(l1, l2);
                }
                int lMax = Math.max(l1, l2);
                int rMax = Math.min(r1, r2);
                return (double)(lMax + rMax) / 2.0;
            }
        }
        return 0.0;
    }
}
