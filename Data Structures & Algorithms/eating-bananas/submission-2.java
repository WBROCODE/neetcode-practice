class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int n  = piles.length;
        int r = 0;
        for(int i = 0; i < n; i++){
            r = Math.max(r, piles[i]);
        }

        while(l < r){
            int m = l + (r - l) / 2;
            if(check(piles, h, m)){
                r = m;
            }else{
                l = m + 1;
            }
        }
        return l;
    }

    public boolean check(int[]piles, int h, int m){
        int time = 0;

        for(int p : piles){
            time += (p + m - 1) / m;
            if(time > h) return false;
        }

        return time <= h;

    }
}
