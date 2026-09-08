class Solution {
    public int lengthOfLIS(int[] nums) {
        /**

        
        */  
        int n = nums.length;
        int[] tops = new int[n];
        int piles = 0;
        for(int i = 0; i < n; i++){
            int target = nums[i];
            int l = 0, r = piles;
            while(l < r){
                int m = l + (r - l)/ 2;
                if(tops[m] >= target){
                    r = m;
                }else l = m + 1;
            }
            if(l == piles){
                piles++;
            }
            tops[l] = target;
        }
        return piles;
    }
}
