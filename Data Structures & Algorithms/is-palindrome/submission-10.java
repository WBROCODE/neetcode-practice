class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();

        int l = 0, r = n - 1;

        while(l < r){
            char chL = s.charAt(l);
            char chR = s.charAt(r);

            if(check(chL) && check(chR)){
                if(Character.toLowerCase(chL) != Character.toLowerCase(chR)) return false;
                l++;
                r--;
            }else if(check(chL)){
                r--;
            }else if(check(chR)){
                l++;
            }else{
                l++;
                r--;
            }
        }

        return true;
    }

    public boolean check(char ch){
        if(ch >= '0' && ch <= '9') return true;
        if(ch >= 'a' && ch <= 'z') return true;
        if(ch >= 'A' && ch <= 'Z') return true;
        return false;
    }
}
