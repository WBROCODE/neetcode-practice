class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for(int p : piles){
            r = Math.max(p, r);
        }

        while(l < r){
            int m = l + (r - l) / 2;
            if(check(m, piles, h)){
                r = m;
            }else l = m + 1;
        }

        return l;
    }

    public boolean check(int m, int[]piles, int h){
        int time = 0;

        for(int p : piles){
            time += (p + m - 1) / m;
            if(time > h) return false;
        }
        return time <= h;
    }
}
