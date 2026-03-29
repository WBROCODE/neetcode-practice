class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int p : piles){
            max = Math.max(p, max);
        }

        int l = 1, r = max;

        while(l < r){
            int m = l + (r - l) / 2;
            if(check(piles, h, m)){
                r = m;
            }else l = m + 1;
        }
        return l;
    }

    public boolean check(int[] piles, int h, int m){
        int hour = 0;

        for(int p : piles){
            hour += (p + m - 1) / m;
        }

        return hour <= h;
    }
}
