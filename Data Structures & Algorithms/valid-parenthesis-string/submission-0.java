class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int minM = 0;
        int maxM = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                minM++;
                maxM++;
            }else if(ch == ')'){
                minM--;
                maxM--;
            }else{
                minM--;
                maxM++;
            }
            if(maxM < 0) return false;
            minM = Math.max(0, minM);
        }
        return minM == 0;
    }
}
