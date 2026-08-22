class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         int[] merged = new int[nums1.length + nums2.length];
        int i = 0, l = 0 , r = 0;

        while(l < nums1.length && r < nums2.length){
            if(nums1[l] <= nums2[r]){
                merged[i]= nums1[l];
                i++;
                l++;
            }else{
                merged[i] = nums2[r];
                r++;
                i++;
            }
        }

        while(l < nums1.length){
            merged[i]= nums1[l];
            i++;
            l++;
        }
        while(r < nums2.length){
            merged[i] = nums2[r];
            r++;
            i++;
        }
        int start = 0, end = nums1.length + nums2.length - 1;
        while(start < end){
            start++;
            end--;
        }
        return (merged[start] + merged[end]) / 2.0;

    }
}
