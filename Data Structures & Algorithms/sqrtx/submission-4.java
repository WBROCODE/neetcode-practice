class Solution {
    public int mySqrt(int x) {
        if(x < 2) return x;
        int l = 1,  r = x / 2;

        while(l <= r){
            int m = l + (r - l) / 2;
            if((long)m * m == x){
                return m;
            }else if((long)m * m > x){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return l - 1;
    }
}