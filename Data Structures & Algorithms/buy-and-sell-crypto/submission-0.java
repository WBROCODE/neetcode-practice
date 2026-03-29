class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1;
        int n = prices.length;
        int ans = 0;

        while(r < n){

            if(prices[l] < prices[r]){   
                ans = Math.max(ans, prices[r] - prices[l]);
            }else{
                l = r;
            }
            r++;
        }

        return ans;
    }
}
