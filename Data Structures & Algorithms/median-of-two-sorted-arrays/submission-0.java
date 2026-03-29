class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a = 0, b = 0, p = 0;

        int m = nums1.length, n = nums2.length;

        int[] merge = new int[m + n];

        while(a < m && b < n){
            if(nums1[a] <= nums2[b]){
                merge[p++] = nums1[a];
                a++;
            }else{
                merge[p++] = nums2[b];
                b++;                
            }
        }

        while(a < m){
            merge[p++] = nums1[a++];
        }

        while(b < n){
            merge[p++] = nums2[b++];
        }

        int start = 0, end = merge.length - 1;

        while(start < end){
            start++;
            end--;
        }

        return (double)(merge[start] + merge[end]) / 2;
    }
}
