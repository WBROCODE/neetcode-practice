class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        
        while(l < r){
            char chL = s.charAt(l);
            char chR = s.charAt(r);

            if(Character.isLetterOrDigit(chL) && Character.isLetterOrDigit(chR)){
                if(Character.toLowerCase(chL) != Character.toLowerCase(chR)) return false;
                l++;
                r--;
            }else if(Character.isLetterOrDigit(chL)){
                r--;
            }else if(Character.isLetterOrDigit(chR)){
                l++;
            }else {
                l++;
                r--;
            }
        }

        return true;
    }
}
