class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1, n = prices.length;
        int ans = 0;
        while(r < n){
            if(prices[r] > prices[l]){
                ans = Math.max(prices[r] - prices[l], ans);
            }else{
                l = r;
            }
            r++;
        }

        return ans;
    }
}
