class Solution {
    public int maxProfit(int[] prices) {
        /**
        
        
        10,1,5,6,7,1
               r
        l
        */


        int l = 0 , r = 0 , n = prices.length;
        int ans = 0;
        while(r < n){
            if(prices[r] > prices[l]){
                ans = Math.max(ans, prices[r] - prices[l]);
            }else l = r;
            r++;
        }
        return ans;
    }
}
