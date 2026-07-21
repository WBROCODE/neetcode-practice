class MinStack {
    /**
    
        3   1           0   0
        1   1           2   1
        2   2           1   1
        S   M
    
    */
    Stack<Integer> minS = new Stack();
    Stack<Integer> st = new Stack();
    public MinStack() {
        
    }
    
    public void push(int val) {
        st.push(val);
        if(minS.isEmpty()){
            minS.push(val);
        }else{
            if(minS.peek() < val){
                minS.push(minS.peek());
            }else{
                minS.push(val);
            }
        } 
    }
    
    public void pop() {
        st.pop();
        minS.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minS.peek();
    }
}
