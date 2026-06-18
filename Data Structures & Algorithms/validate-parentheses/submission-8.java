class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = Map.of(
            ')','(',
            ']','[',
            '}','{'
         );

         Stack<Character> st = new Stack();

         for(char ch : s.toCharArray()){
            // ( [ {
            if(!map.containsKey(ch)) st.push(ch);
            else{
                if(st.isEmpty()) return false;
                // pop->(        map->}  {
                if(st.pop() != map.get(ch)) return false;
            }
         }

          return st.isEmpty();
    }
}
