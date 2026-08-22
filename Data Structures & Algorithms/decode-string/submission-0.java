class Solution {
    public String decodeString(String s) {
        /**
            ab
            2
        
        */

        int n = s.length();
        Stack<Integer> nums = new Stack();
        Stack<StringBuilder> strs = new Stack();
        StringBuilder cur = new StringBuilder();
        int k = 0;
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                k = k * 10 + ch - '0';
            }else if(Character.isLetter(ch)){
                cur.append(ch);
            }else if(ch == '['){
                nums.push(k);
                strs.push(cur);
                k = 0;
                cur = new StringBuilder();
            }else if(ch == ']'){
                /**
                    cur abc
                */
                int time = nums.pop();
                StringBuilder prev = strs.pop();
                for(int j = 0;j < time; j++){
                    prev.append(cur);
                }
                cur = prev;
            }
        }
        return cur.toString();
    }
}