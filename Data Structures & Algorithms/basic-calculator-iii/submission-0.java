class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }else if(s.charAt(i) == ')'){
                int l = st.pop();
                map.put(l, i);
            }
        }
        return calculate(0, s.length() - 1, s, map);
    }


    public int calculate(int s, int e, String str, Map<Integer, Integer> map){
        Stack<Integer> st = new Stack();
        char sign = '+';
        int num = 0;
        for(int i = s; i <= e; i++){
            char ch = str.charAt(i);
            if(Character.isDigit(ch)){
                num = num * 10 + ch - '0';
            }
            if(ch == '('){
                int recurE = map.get(i) - 1; 
                num = calculate(i + 1, recurE, str, map);
                i = recurE + 1;
                ch = str.charAt(i);
            }
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || i == e){
                if(sign == '+'){
                    st.push(num);
                }else if(sign == '-'){
                    st.push(-num);
                }else if(sign == '*'){
                    int prev = st.pop();
                    st.push(prev * num);
                }else if(sign == '/'){
                    int prev = st.pop();
                    st.push(prev / num);
                }
                num = 0;
                sign = ch;
            }
           
        }

        int ans = 0;
        while(!st.isEmpty()){
            ans+=st.pop();
        }

        return ans;
    }
}
