class Solution {
    public boolean isValid(String s) {
        /**
        
        
        { }
        [ ]
        ( )
        */
        int n = s.length();
        Stack<Character> stack = new Stack();
        Map<Character, Character> map = Map.of(
            '{','}',
            '[', ']',
            '(', ')'
        );
        for(char ch : s.toCharArray()){
            if(map.containsKey(ch)){
                stack.push(map.get(ch));
            }else{
                if(stack.isEmpty()) return false;
                char peek = stack.pop();
                if(ch != peek) return false;
            }
        }
        return stack.isEmpty();

    }
}
