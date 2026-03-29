class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        Map<Character, Character> map = Map.of(
            ')','(',
            ']','[',
            '}','{'
        );
           

        for(char ch : s.toCharArray()){

            if(map.containsKey(ch)){
                if(!stack.isEmpty() && stack.peek()==map.get(ch)){
                    stack.pop();
                }else return false;
            }else stack.push(ch);
        }
        
        return stack.isEmpty();
    }
}
