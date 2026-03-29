class Solution {
    public int evalRPN(String[] tokens) {
        int ans = 0;

        Stack<Integer> st = new Stack();

        for(String token : tokens){
            if(token.equals("+") ||
               token.equals("-") ||
               token.equals("*") ||
               token.equals("/")
            ){
                int two = st.pop();
                int one = st.pop();
                if(token.equals("+")){
                    int newNum = one + two;
                    st.push(newNum);
                }else if(token.equals("-")){
                    int minus = one - two;
                    st.push(minus);
                }else if(token.equals("*")){
                    int multi = one * two;
                    st.push(multi);                    
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
