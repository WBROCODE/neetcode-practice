class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
            even
            1: 1,3,5
            l1 + l2 <= r1 + r2
            max(l)   min(r)
            2: 2,4,6
            median: 3 + 4 / 2 3.5

            half: m + n

            i: mid of left
            j: half - i

            l1  i : 0 | i - 1
            l2  j: 0 | j - 1
            r1  i : m | i
            r1  j : m | j

            odd
            1: 1,3
            l1 + l2 <= r1 + r2
            max(l)   min(r)
            2: 2,4,6
            median: 3

            half: m + n 3

            i: mid of left
            j: half - i

            l1  i : 0 | i - 1
            l2  j: 0 | j - 1
            r1  i : m | i
            r1  j : m | j

        */
        int m = nums1.length, n = nums2.length;
        if(n < m) return findMedianSortedArrays(nums2, nums1);
        int l = 0, r = m;
        int half = (m + n + 1) / 2;

        while(l <= r){
            int mid = l + (r - l) / 2;
            int leftInTwo = half - mid;

            int l1 = mid == 0 ? Integer.MIN_VALUE : nums1[mid - 1];
            int l2 = leftInTwo == 0 ? Integer.MIN_VALUE : nums2[leftInTwo - 1];
            int r1 = mid == m ? Integer.MAX_VALUE : nums1[mid];
            int r2 = leftInTwo == n ? Integer.MAX_VALUE : nums2[leftInTwo];

            if(l1 > r2){
                r = mid - 1;
            }else if(l2 > r1){
                l = mid + 1;
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
