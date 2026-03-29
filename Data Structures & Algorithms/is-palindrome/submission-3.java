class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while(l < r){
            char chL = s.charAt(l);
            char chR = s.charAt(r);
            if(Character.isLetterOrDigit(chL) && Character.isLetterOrDigit(chR)){
                chL = Character.toLowerCase(chL);
                chR = Character.toLowerCase(chR);
                if(chL != chR) return false;
                l++;
                r--;
            }else if(!Character.isLetterOrDigit(chL)){
                l++;
            }else if(!Character.isLetterOrDigit(chR)){
                r--;
            }else{
                l++;
                r--;
            }
        }
        return true;

    }
}
