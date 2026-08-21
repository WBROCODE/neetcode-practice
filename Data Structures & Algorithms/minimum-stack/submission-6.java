class MinStack {
    Stack<Integer> st;
    Stack<Integer> min;
    public MinStack() {
        st = new Stack();
        min = new Stack();
    }
    /**
    
    1   2  0  
    1   1  0
    */
    public void push(int val) {
        if(st.isEmpty()){
            min.push(val);
            st.push(val);
        }else{
            int minV = min.peek();

            if(minV < val){
                min.push(minV);
            }else{
                min.push(val);
            }
            st.push(val);
        }
    }
    
    public void pop() {
        st.pop();
        min.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
