class Solution {
    public int climbStairs(int n) {
        /**
        1 + 1 
        2 + 0
        

        1 + 1 + 1
        2+ 0 + 1
        2 + 

        */
        if(n <= 2) return n;


        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
