class Solution {
    public boolean isValid(String s) {
        /**
                []
                {}
                ()



                ( )
                { }
                

                { }
        */

        Map<Character, Character> map = Map.of(
            '[', ']',
            '(', ')',
            '{', '}'            
        );

        Stack<Character> st = new Stack();

        for(char ch : s.toCharArray()){
            if(ch == ']' || ch == '}' || ch == ')'){
                if(st.isEmpty()) return false;
                char peek = st.pop();
                if(map.get(peek) != ch) return false;
            }else{
                st.push(ch);
            }
        }

        return st.isEmpty();
    }
}
