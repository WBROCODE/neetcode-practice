class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack();
        char sign = '+';
        int n = s.length();
        /**
                2
                +
                3
        */
           int num = 0;
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num * 10 + ch - '0';
            }
            if(ch == '*' || ch == '-' || ch == '+' || ch == '/' || i == n - 1){
                if(sign == '+'){
                    st.push(num);
                }else if(sign == '-'){
                    st.push(-num);
                }else if(sign == '*'){
                    int peek = st.pop();
                    st.push(peek * num);
                }else if(sign == '/'){
                    int peek = st.pop();
                    st.push(peek / num);
                }
                sign = ch;
                num = 0;
            }
        }
        int ans = 0;
        while(!st.isEmpty()){
            ans += st.pop();
        }
        return ans;
    }
}