class Solution {
    public int maxProfit(int[] prices) {
        /**
        0  1 2 3 4 5 
        10,1,5,6,7,1
        
           b     
                 
                 s
        */
        int ans = 0;

        int l = 0, r = 0, n = prices.length;

        while(r < n){
            if(prices[r] > prices[l]){
                ans = Math.max(ans, prices[r] - prices[l]);
            }else{
                l = r;
            }
            r++;
        }
        return ans;
    }
}
