class MinStack {
    Stack<Integer> st;
    Stack<Integer> min;
    public MinStack() {
        st = new Stack();
        min = new Stack();
    }
    
    public void push(int val) {
        st.push(val);
        if(min.isEmpty() || min.peek() > val){
            min.push(val);
        }else{
            min.push(min.peek());
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
