class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] top = new int[n];
        int piles = 0;

        for(int i = 0; i < n; i++){
            int poker = nums[i];
            int l = 0, r = piles;
            while(l < r){
                int m =  l + (r - l) / 2;
                if(top[m] >= poker){
                    r = m;
                }else l = m + 1;
            }

            if(l == piles){
                piles++;
            }
            top[l] = poker;
        }

        return piles;

    }
}
