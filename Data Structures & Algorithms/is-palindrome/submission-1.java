class Solution {
     public boolean isPalindrome(String s) {
        /**
        
              L                         R
            A man, a plan, a canal: Panama
         */

         int l = 0, r = s.length() - 1;

        while(l < r){

            char chL = s.charAt(l);
            char chR = s.charAt(r);

            if(isAlphanumeric(chL) && isAlphanumeric(chR)){
                if(Character.toLowerCase(chL) == (Character.toLowerCase(chR))){
                    l++;
                    r--;
                }else return false;
            }else if(isAlphanumeric(chL)) r--;
            else if(isAlphanumeric(chR)) l++;
            else{
                l++;
                r--;
            }      


        }

        return true;
    }

    public boolean isAlphanumeric(char ch){
        if (ch >= '0' && ch <= '9') return true;
        if (ch >= 'a' && ch <= 'z') return true;
        if (ch >= 'A' && ch <= 'Z') return true;
        return false;
    }
}
