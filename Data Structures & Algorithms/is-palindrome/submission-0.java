class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(Character.isLetterOrDigit(ch)) sb.append(Character.toLowerCase(ch));
        }

        String newS = sb.toString();
        String rev = sb.reverse().toString();
        if(!newS.equals(rev)) return false;

        return true;
    }
}
