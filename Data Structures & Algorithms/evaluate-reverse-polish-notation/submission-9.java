class Solution {
    public int evalRPN(String[] tokens) {
        /**
        
        
        */
        Stack<Integer> st = new Stack();
        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int one = st.pop();
                int two = st.pop();
                if(token.equals("+")){
                    st.push(one + two);
                }else if(token.equals("-")){
                    st.push(two - one);
                }else if(token.equals("*")){
                    st.push(one * two);
                }else{
                    st.push((int)two / one);
                }
            }else{
                st.push(Integer.parseInt(token));
            }
        }
        return st.peek();
    }
}
