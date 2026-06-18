class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;

        int cur = x;
        int total = 0;
        while(cur != 0){
            int carry = cur % 10;
            cur /= 10;
            total = total * 10 + carry;
        }

        return total == x;
    }
}