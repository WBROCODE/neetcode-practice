class Solution {
    public boolean isValid(String s) {
        int n = s.length();

        Map<Character, Character> map = Map.of(
            '{', '}', 
            '(', ')', 
            '[', ']' 
        );

        Stack<Character> st = new Stack();

        for(char ch : s.toCharArray()){
            if(map.containsKey(ch)){
                st.push(map.get(ch));
            }else{
                if(!st.isEmpty()){
                    if(st.peek() != ch) return false;
                    else st.pop();
                }else return false;
            }
        }
        return st.isEmpty();
    }
}
