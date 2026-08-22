class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        /**     
            1,   4
            check  <=h
            n: len of piles
            n * log m
        */

        int l = 1, r = 1;
        for(int p : piles) r = Math.max(r, p);

        while(l < r){
            int m = l + (r - l) / 2;
            if(check(m, piles, h)){
                r = m;
            }else{
                l = m + 1;
            }
        }

        return l;
    }

    public boolean check(int m, int[]piles, int h){
        int time = 0;
        for(int pile : piles){
            time += (pile + m - 1) / m;
            if(time > h) return false;
        }

        return time <= h;
    }
}
