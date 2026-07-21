class Solution {
    public boolean isValid(String s) {
        /**
            ][

        */
        Map<Character, Character> map = Map.of(
            ']', '[',
            '}', '{',
            ')', '('
        );

        Stack<Character> st = new Stack();

        for(char ch : s.toCharArray()){
            if(map.containsKey(ch)){
                if(st.isEmpty() || map.get(ch) != st.peek() ) return false;
                st.pop();
            }else{
                st.push(ch);
            }
        }

        return st.isEmpty();
    }
}
