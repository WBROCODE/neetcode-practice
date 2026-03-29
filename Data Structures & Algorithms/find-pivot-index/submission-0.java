class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length == 1) return 0;
        List<Integer> prefixSum = new ArrayList<>();

        int total = 0;
        prefixSum.add(0);
        for(int num : nums){
            total += num;
            prefixSum.add(total);
        }

        
        /**
        1 7  3  6  5  6 
        1 8 11 17 22 28
             l  
                r 
    t = 28 - 11  = 17       
        
        */

        int l = 0, r = 1, n = nums.length;
        while(r <= n){
            int sumL = prefixSum.get(l);
            int sumR = total - prefixSum.get(r);           
            if(sumL == sumR) return r - 1;
            else{
                l++;
                r++;
            }

        }
        return -1;
    }
}