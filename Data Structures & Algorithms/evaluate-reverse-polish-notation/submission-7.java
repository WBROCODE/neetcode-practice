class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack();

        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int two = st.pop();
                int one = st.pop();
                if(token.equals("+")){
                    st.push(one + two);
                }else if(token.equals("-")){
                    st.push(one - two);
                }else if(token.equals("*")){
                    st.push(one * two);
                }else{
                    int divide = one / two;
                    st.push(divide);
                }
            }else{
                st.push(Integer.parseInt(token));
            }
        }
        return st.peek();

    }
}
