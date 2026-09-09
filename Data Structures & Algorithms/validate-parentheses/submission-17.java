class Solution {
    public boolean isValid(String s) {
        /**
        ][
        }{
        )(
        */


        if(s.length() == 0) return true;
        int n = s.length();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> st = new Stack();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                if(!st.isEmpty() && st.pop() == map.get(ch)) continue;
                else return false;
            }else{
                st.push(ch);
            }
        }
        return st.isEmpty();
    }
}
